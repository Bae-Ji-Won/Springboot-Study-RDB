package com.jpa.exercise.Controller;

import com.jpa.exercise.Domain.DTO.HospitalResponseWithReview;
import com.jpa.exercise.Domain.DTO.ReviewReadResponse;
import com.jpa.exercise.Domain.DTO.ReviewRequest;
import com.jpa.exercise.Domain.DTO.ReviewResponse;
import com.jpa.exercise.Domain.Hospital;
import com.jpa.exercise.Service.HospitalService;
import com.jpa.exercise.Service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/hospital")
@RequiredArgsConstructor
public class HospitalController {
    private final ReviewService reviewService;
    private final HospitalService hospitalService;


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

    // 병원 정보와 해당하는 리뷰 전체 출력
    @GetMapping("/{id}")
    public ResponseEntity<HospitalResponseWithReview> notice(@PathVariable long id){
        Hospital hospital = hospitalService.findById(id);       // 현재 게시물의 데이터를 가져옴
        return ResponseEntity.ok().body(HospitalResponseWithReview.fromEntity(hospital));
        // HospitalResponseWithReview의 fromEntity builder를 통해 DTO구조의 값을 가져옴
    }
}
