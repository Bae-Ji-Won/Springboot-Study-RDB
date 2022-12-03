package com.jpa.exercise.Domain.DTO;

import com.jpa.exercise.Domain.Review;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Getter
@Builder
@NoArgsConstructor
public class ReviewReadResponse {
    private Long id;
    private String title;
    private String content;
    private String patientName;
    private String hospitalName;

    // Entity에서 값을 받아와 원하는 DTO 구조로 변환
    // 이때 hospitalName은 Hospital DB에서 가져와야 하므로 관계형 DB를 통해 FK가 가르키는 DB인 Hospital에서 데이터를 가져온다.
    public static ReviewReadResponse fromEntity(Review review) {
        ReviewReadResponse response = ReviewReadResponse.builder()
                .id(review.getId())
                .title(review.getTitle())
                .content(review.getContent())
                .patientName(review.getUserName())
                .hospitalName(review.getHospital().getHospitalName())
                .build();
        return response;
    }
}
