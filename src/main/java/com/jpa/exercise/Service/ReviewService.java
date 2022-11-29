package com.jpa.exercise.Service;

import com.jpa.exercise.Domain.DTO.ReviewReadResponse;
import com.jpa.exercise.Domain.DTO.ReviewRequest;
import com.jpa.exercise.Domain.DTO.ReviewResponse;
import com.jpa.exercise.Domain.Hospital;
import com.jpa.exercise.Domain.Review;
import com.jpa.exercise.Repository.HospitalRepository;
import com.jpa.exercise.Repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final HospitalRepository hospitalRepository;

    public ReviewService(ReviewRepository reviewRepository, HospitalRepository hospitalRepository) {
        this.reviewRepository = reviewRepository;
        this.hospitalRepository = hospitalRepository;
    }

    // 리뷰 DB저장
    public ReviewResponse ReviewAdd(Long id,ReviewRequest reviewRequest){
        Optional<Hospital> hospital = hospitalRepository.findById(id);   // 유저가 리뷰를 작성하고자 하는 게시물 번호를 가져와 해당 데이터를 호출함
        Review review = Review.builder()
                .title(reviewRequest.getTitle())        // 유저가 작성한 리뷰 데이터의 값(ReviewRequest)을 Review Entity에 저장함
                .content(reviewRequest.getContent())
                .userName(reviewRequest.getUserName())
                .hospital(hospital.get())               //
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

    // 리뷰 id별 조회
    public Review getReview(Long id) {
        // Optional<Review> review = reviewRepository.findById(id);
        // Optional을 통해 null값 예외처리를 했는데 이제는 세부적으로 예외 처리를 하도록 한다.
        // Optional을 썻을때 .orElseThrow(), orElse(), ifPresent()등 편의기능을 써서 코드를 간편화 할 수 있음
        Optional<Review> review = reviewRepository.findById(id);
        review.orElseThrow(() -> new RuntimeException("해당 id가 없습니다."));

        return review.get();
    }

    // 해당 게시물에 대한 모든 리뷰 조회
    public List<ReviewReadResponse> getTotalReview(Long id){
        Hospital hospital = hospitalRepository.findById(id)      // 게시물 번호에 해당하는 hospital 데이터를 호출함
                .orElseThrow(() -> new IllegalArgumentException("해당 id가 없습니다."));   // 해당 번호에 대한 데이터가 없다면 해당 문자 출력

        // Review DB에서 위에서 찾은 hospital에 대한 데이터를 가진 데이터를 가져옴
        // 이때 ReviewReadResponse는 제목,내용,환자이름,병원이름만 필요하므로 hospital의 데이터중 HospitalName만 필요하다
        // 따라서 stream.map을 통해 맵핑을 진행한다.
        List<ReviewReadResponse> reviews = reviewRepository.findByHospital(hospital)
                .stream().map(review -> ReviewReadResponse.builder()
                        .title(review.getTitle())
                        .content(review.getContent())
                        .patientName(review.getPatientName())
                        .hospitalName(hospital.getHospitalName())
                        .build()
                ).collect(Collectors.toList());

        return reviews;
    }
}

