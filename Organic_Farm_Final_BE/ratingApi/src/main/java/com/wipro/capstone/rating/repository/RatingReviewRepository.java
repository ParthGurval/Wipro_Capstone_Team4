package com.wipro.capstone.rating.repository;


import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.capstone.rating.entity.Rating;
import com.wipro.capstone.rating.entity.RatingReview;


@Repository
public interface RatingReviewRepository extends JpaRepository<RatingReview, Long> {
	
	List<RatingReview> findByCustomerId(Long customerId);
	List<RatingReview> findByPartnerId(Long partnerId);
}
