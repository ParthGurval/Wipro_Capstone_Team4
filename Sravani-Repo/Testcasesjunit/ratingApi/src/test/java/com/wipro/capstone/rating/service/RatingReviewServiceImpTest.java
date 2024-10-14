package com.wipro.capstone.rating.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.wipro.capstone.rating.dto.RatingReviewDTO;
import com.wipro.capstone.rating.entity.Rating;
import com.wipro.capstone.rating.entity.RatingReview;
import com.wipro.capstone.rating.repository.RatingReviewRepository;

class RatingReviewServiceImpTest {

    @InjectMocks
    private RatingReviewServiceImp ratingReviewService;

    @Mock
    private RatingReviewRepository ratingReviewRepository;

    // Common test data
    private RatingReview testRatingReview;
    private RatingReviewDTO testRatingReviewDTO;

    @BeforeAll
    static void setUpBeforeClass() throws Exception {
        System.out.println("Setting up the tests...");
    }

    @AfterAll
    static void tearDownAfterClass() throws Exception {
        System.out.println("Cleaning up after all tests...");
    }

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        
        // Initialize common test data
        testRatingReview = new RatingReview();
        testRatingReview.setReview_id(1L);
        testRatingReview.setCustomerId(1L);
        testRatingReview.setPartnerId(2L);
        testRatingReview.setRating(Rating.FIVE);
        testRatingReview.setReview_text("Excellent service");

        testRatingReviewDTO = new RatingReviewDTO(1L, 1L, 2L, Rating.FIVE, "Excellent service");
    }

    @Test
    void testCreateRatingReview() {
        // Arrange
        when(ratingReviewRepository.save(any(RatingReview.class))).thenReturn(testRatingReview);

        // Act
        RatingReview result = ratingReviewService.createRatingReview(testRatingReviewDTO);

        // Assert
        assertNotNull(result);
        assertEquals(1L, result.getReview_id());
        assertEquals(Rating.FIVE, result.getRating());
        assertEquals("Excellent service", result.getReview_text());
    }

    @Test
    void testGetRatingReviewById() {
        // Arrange
        when(ratingReviewRepository.findById(1L)).thenReturn(Optional.of(testRatingReview));

        // Act
        RatingReviewDTO result = ratingReviewService.getRatingReviewById(1L);

        // Assert
        assertNotNull(result);
        assertEquals(1L, result.getReview_id());
        assertEquals(Rating.FIVE, result.getRating());
        assertEquals("Excellent service", result.getReview_text());
    }

    @Test
    void testGetAllRatingReviews() {
        // Arrange
        List<RatingReview> reviews = Arrays.asList(testRatingReview);

        when(ratingReviewRepository.findAll()).thenReturn(reviews);

        // Act
        List<RatingReview> result = ratingReviewService.getAllRatingReviews();

        // Assert
        assertEquals(1, result.size());
        assertEquals(testRatingReview, result.get(0));
    }

    @Test
    void testUpdateRatingReview() {
        // Arrange
        when(ratingReviewRepository.findById(1L)).thenReturn(Optional.of(testRatingReview));
        when(ratingReviewRepository.save(any(RatingReview.class))).thenReturn(testRatingReview);

        // Act
        RatingReview result = ratingReviewService.updateRatingReview(testRatingReviewDTO);

        // Assert
        assertNotNull(result);
        assertEquals(1L, result.getReview_id());
        assertEquals(Rating.FIVE, result.getRating());
        assertEquals("Excellent service", result.getReview_text());
    }

    @Test
    void testDeleteRatingReview() {
        // Arrange
        Long reviewId = 1L;

        // Act
        String result = ratingReviewService.deleteRatingReview(reviewId);

        // Assert
        assertEquals("Record Deleted For Review ID: " + reviewId, result);
        verify(ratingReviewRepository, times(1)).deleteById(reviewId);
    }

    @Test
    void testGetRatingByCustomerId() {
        // Arrange
        List<RatingReview> reviews = Arrays.asList(testRatingReview);

        when(ratingReviewRepository.findByCustomerId(1L)).thenReturn(reviews);

        // Act
        List<RatingReviewDTO> result = ratingReviewService.getRatingByCustomerId(1L);

        // Assert
        assertEquals(1, result.size());
        assertEquals(Rating.FIVE, result.get(0).getRating());
        assertEquals("Excellent service", result.get(0).getReview_text());
    }

    @Test
    void testGetRatingByFarmPartnerId() {
        // Arrange
        List<RatingReview> reviews = Arrays.asList(testRatingReview);

        when(ratingReviewRepository.findByPartnerId(2L)).thenReturn(reviews);

        // Act
        List<RatingReviewDTO> result = ratingReviewService.getRatingByFarmPartnerId(2L);

        // Assert
        assertEquals(1, result.size());
        assertEquals(Rating.FIVE, result.get(0).getRating());
        assertEquals("Excellent service", result.get(0).getReview_text());
    }
}
