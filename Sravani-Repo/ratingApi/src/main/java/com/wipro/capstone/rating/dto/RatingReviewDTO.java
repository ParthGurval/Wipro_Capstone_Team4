package com.wipro.capstone.rating.dto;

import com.wipro.capstone.rating.entity.Rating;

public class RatingReviewDTO {

    private Long review_id;
    private Long customer_id;
    private Long farmpartner_id;
    private Rating rating;
    private String review_text;

    public Long getReview_id() {
        return review_id;
    }

    public void setReview_id(Long review_id) {
        this.review_id = review_id;
    }

    public Long getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Long customer_id) {
        this.customer_id = customer_id;
    }

    public Long getFarmpartner_id() {
        return farmpartner_id;
    }

    public void setFarmpartner_id(Long farmpartner_id) {
        this.farmpartner_id = farmpartner_id;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public String getReview_text() {
        return review_text;
    }

    public void setReview_text(String review_text) {
        this.review_text = review_text;
    }
}

