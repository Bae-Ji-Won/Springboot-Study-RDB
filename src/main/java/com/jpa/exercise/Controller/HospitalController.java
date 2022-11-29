package com.jpa.exercise.Controller;

import com.jpa.exercise.Domain.DTO.ReviewReadResponse;
import com.jpa.exercise.Domain.DTO.ReviewRequest;
import com.jpa.exercise.Domain.DTO.ReviewResponse;
import com.jpa.exercise.Service.ReviewService;
import lombok.Getter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/hospital")
public class HospitalController {
    private final ReviewService reviewService;

    public HospitalController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }


    // 리뷰 등록
    @PostMapping("/{id}/review")
    public ResponseEntity<ReviewResponse> ReviewAdd(@PathVariable Long id, @RequestBody ReviewRequest reviewRequest){
        return ResponseEntity.ok().body(reviewService.ReviewAdd(id,reviewRequest));
    }

    // 게시물에 대한 모든 리뷰 출력
    @GetMapping("/{id}/reviews")
    public ResponseEntity<List<ReviewReadResponse>> reviews(@PathVariable(name = "id") Long hospitalid){
        return ResponseEntity.ok().body(reviewService.getTotalReview(hospitalid));
    }
}
