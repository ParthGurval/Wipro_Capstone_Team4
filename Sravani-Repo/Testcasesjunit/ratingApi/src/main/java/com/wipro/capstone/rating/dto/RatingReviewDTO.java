package com.wipro.capstone.rating.dto;

import com.wipro.capstone.rating.entity.Rating;

public class RatingReviewDTO {

    private Long review_id;
    private Long customerId;
    private Long partnerId;
    private Rating rating;
    private String review_text;
    
	public RatingReviewDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RatingReviewDTO(Long review_id, Long customerId, Long partnerId, Rating rating, String review_text) {
		super();
		this.review_id = review_id;
		this.customerId = customerId;
		this.partnerId = partnerId;
		this.rating = rating;
		this.review_text = review_text;
	}

	public Long getReview_id() {
		return review_id;
	}

	public void setReview_id(Long review_id) {
		this.review_id = review_id;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public Long getPartnerId() {
		return partnerId;
	}

	public void setPartnerId(Long partnerId) {
		this.partnerId = partnerId;
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

	@Override
	public String toString() {
		return "RatingReviewDTO [review_id=" + review_id + ", customerId=" + customerId + ", partnerId=" + partnerId
				+ ", rating=" + rating + ", review_text=" + review_text + "]";
	}

    
}

