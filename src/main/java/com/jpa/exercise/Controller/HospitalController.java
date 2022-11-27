package com.jpa.exercise.Controller;

import com.jpa.exercise.Domain.DTO.ReviewRequest;
import com.jpa.exercise.Domain.DTO.ReviewResponse;
import com.jpa.exercise.Service.ReviewService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/hospital")
public class HospitalController {
    private final ReviewService reviewService;

    public HospitalController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping("/{id}/review")
    public ResponseEntity<ReviewResponse> reviewget(@PathVariable Integer id, @RequestBody ReviewRequest reviewRequest){
        return ResponseEntity.ok().body(reviewService.ReviewAdd(reviewRequest));
    }
}
