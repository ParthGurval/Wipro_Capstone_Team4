package com.wipro.capstone.rating.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "rating_review")
public class RatingReview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long review_id;

    private Long customerId;
    
    private Long partnerId;

    @Enumerated(EnumType.STRING)
    private Rating rating;

    private String review_text;

	public RatingReview() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RatingReview(Long review_id, Long customerId, Long partnerId, Rating rating, String review_text) {
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
		return "RatingReview [review_id=" + review_id + ", customerId=" + customerId + ", partnerId=" + partnerId
				+ ", rating=" + rating + ", review_text=" + review_text + "]";
	}

    
}

