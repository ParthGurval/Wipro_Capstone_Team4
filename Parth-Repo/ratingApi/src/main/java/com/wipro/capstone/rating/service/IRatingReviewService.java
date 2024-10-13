package com.wipro.capstone.rating.service;

import java.util.List;


import com.wipro.capstone.rating.dto.RatingReviewDTO;
import com.wipro.capstone.rating.entity.RatingReview;

public interface IRatingReviewService {

    public RatingReview createRatingReview(RatingReviewDTO ratingReviewDTO);
    
    public RatingReviewDTO getRatingReviewById(Long review_id);
    
    public List<RatingReview> getAllRatingReviews();
    
    public RatingReview updateRatingReview(RatingReviewDTO ratingReviewDTO);
    
    public String deleteRatingReview(Long review_id);
    
    public List<RatingReviewDTO> getRatingByCustomerId(Long customerId);
    
    public List<RatingReviewDTO> getRatingByFarmPartnerId(Long partnerId);
}
