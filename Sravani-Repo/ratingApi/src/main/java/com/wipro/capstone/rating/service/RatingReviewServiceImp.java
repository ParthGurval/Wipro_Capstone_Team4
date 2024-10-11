package com.wipro.capstone.rating.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wipro.capstone.rating.dto.RatingReviewDTO;
import com.wipro.capstone.rating.entity.RatingReview;
import com.wipro.capstone.rating.repository.RatingReviewRepository;


@Service
public class RatingReviewServiceImp implements IRatingReviewService {

    @Autowired
    private RatingReviewRepository ratingReviewRepository;

    @Override
    public RatingReview createRatingReview(RatingReviewDTO ratingReviewDTO) {
        RatingReview ratingReview = new RatingReview();

        ratingReview.setCustomer_id(ratingReviewDTO.getCustomer_id());
        ratingReview.setFarmpartner_id(ratingReviewDTO.getFarmpartner_id());
        ratingReview.setRating(ratingReviewDTO.getRating());
        ratingReview.setReview_text(ratingReviewDTO.getReview_text());

        return ratingReviewRepository.save(ratingReview);
    }

    @Override
    public RatingReviewDTO getRatingReviewById(Long review_id) {
        RatingReview ratingReview = ratingReviewRepository.findById(review_id).orElse(null);
        
        RatingReviewDTO ratingReviewDto = new RatingReviewDTO();
        ratingReviewDto.setReview_id(ratingReview.getReview_id());
        ratingReviewDto.setCustomer_id(ratingReview.getCustomer_id());
        ratingReviewDto.setFarmpartner_id(ratingReview.getFarmpartner_id());
        ratingReviewDto.setRating(ratingReview.getRating());
        ratingReviewDto.setReview_text(ratingReview.getReview_text());

        return ratingReviewDto;
    }

    @Override
    public List<RatingReview> getAllRatingReviews() {
        return ratingReviewRepository.findAll();
    }

    @Override
    public RatingReview updateRatingReview(RatingReviewDTO ratingReviewDTO) {
        RatingReview ratingReview = new RatingReview();
        
        ratingReview.setReview_id(ratingReviewDTO.getReview_id());
        ratingReview.setCustomer_id(ratingReviewDTO.getCustomer_id());
        ratingReview.setFarmpartner_id(ratingReviewDTO.getFarmpartner_id());
        ratingReview.setRating(ratingReviewDTO.getRating());
        ratingReview.setReview_text(ratingReviewDTO.getReview_text());

        return ratingReviewRepository.save(ratingReview);
    }

    @Override
    public String deleteRatingReview(Long review_id) {
        ratingReviewRepository.deleteById(review_id);
        return "Record Deleted For Review ID: " + review_id;
    }
}
