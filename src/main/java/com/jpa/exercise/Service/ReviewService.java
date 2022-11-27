package com.jpa.exercise.Service;

import com.jpa.exercise.Domain.DTO.ReviewRequest;
import com.jpa.exercise.Domain.DTO.ReviewResponse;
import com.jpa.exercise.Domain.Hospital;
import com.jpa.exercise.Domain.Review;
import com.jpa.exercise.Repository.HospitalRepository;
import com.jpa.exercise.Repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final HospitalRepository hospitalRepository;

    public ReviewService(ReviewRepository reviewRepository, HospitalRepository hospitalRepository) {
        this.reviewRepository = reviewRepository;
        this.hospitalRepository = hospitalRepository;
    }

    public ReviewResponse ReviewAdd(ReviewRequest reviewRequest){
        Optional<Hospital> hospital = hospitalRepository.findById(reviewRequest.getHospitalId());
        Review review = Review.builder()
                .title(reviewRequest.getTitle())
                .content(reviewRequest.getContent())
                .userName(reviewRequest.getUserName())
                .hospital(hospital.get())
                .build();
        Review savedReview = reviewRepository.save(review);
        ReviewResponse reviewResponse = ReviewResponse.builder()
                .id(savedReview.getId())
                .title(savedReview.getTitle())
                .content(savedReview.getContent())
                .userName(savedReview.getUserName())
                .message("리뷰가 추가되었습니다.")
                .build();
        return reviewResponse;
    }
}

