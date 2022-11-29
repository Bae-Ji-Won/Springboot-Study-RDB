package com.jpa.exercise.Controller;

import com.jpa.exercise.Domain.DTO.ReviewReadResponse;
import com.jpa.exercise.Domain.Review;
import com.jpa.exercise.Service.ReviewService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/reviews")
@RequiredArgsConstructor        // 의존하는 클래스의 생성자 생성을 대신해줌
public class ReviewController {

    private final ReviewService reviewService;

//    @RequiredArgsConstructor로 인해 생성자 작성 안해줘도 됨
//    public ReviewController(ReviewService reviewService) {
//        this.reviewService = reviewService;
//    }

    // 리뷰 1개 조회 기능
    @GetMapping("/{id}")
    public ResponseEntity<ReviewReadResponse> get(@PathVariable Long id){
        Review review = reviewService.getReview(id);
        ReviewReadResponse reviewReadResponse = ReviewReadResponse.builder()
                .id(review.getId())
                .title(review.getTitle())
                .content(review.getContent())
                .patientName(review.getUserName())
                .hospitalName(review.getHospital().getHospitalName())
                .build();

        return ResponseEntity.ok().body(reviewReadResponse);
    }
}
