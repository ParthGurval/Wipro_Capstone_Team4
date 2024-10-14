package com.wipro.capstone.rating.controller;



import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.capstone.rating.dto.RatingReviewDTO;
import com.wipro.capstone.rating.entity.RatingReview;
import com.wipro.capstone.rating.service.IRatingReviewService;



@RestController
@RequestMapping("/api/ratingReviews")
public class RatingReviewController {

    @Autowired
    private IRatingReviewService ratingReviewService;
    
    // Create new rating and review
    @PostMapping(value="/createRatingReview")
    public RatingReview createRatingReview(@RequestBody RatingReviewDTO ratingReviewDTO) {
        return ratingReviewService.createRatingReview(ratingReviewDTO);
    }
    
    // Get rating and review by ID
    @GetMapping(value="/getbyid/{review_id}")
    public RatingReviewDTO getRatingReviewById(@PathVariable Long review_id) {
        return ratingReviewService.getRatingReviewById(review_id);
    }
    
    // Get all rating and reviews
    @GetMapping("/getallRatingReviews")
    public List<RatingReview> getAllRatingReviews() {
        return ratingReviewService.getAllRatingReviews();
    }
    
    // Update a rating and review
    @PutMapping("/updateRatingReview")
    public RatingReview updateRatingReview(@RequestBody RatingReviewDTO ratingReviewDTO) {
        return ratingReviewService.updateRatingReview(ratingReviewDTO);
    }
    
    // Delete a rating and review by ID
    @DeleteMapping("/deletebyid/{review_id}")
    public String deleteRatingReviewById(@PathVariable Long review_id) {
        return ratingReviewService.deleteRatingReview(review_id);
    }
    
    @GetMapping("/getRatingByCust/{customerId}")
    public List<RatingReviewDTO> getRatingByCust(@PathVariable Long customerId){
    	
    	return ratingReviewService.getRatingByCustomerId(customerId);
    }
    
    @GetMapping("/getRatingByFarmPartner/{partnerId}")
    public List<RatingReviewDTO> getRatingByPartner(@PathVariable Long partnerId){
    	
    	return ratingReviewService.getRatingByFarmPartnerId(partnerId);
    }

}

