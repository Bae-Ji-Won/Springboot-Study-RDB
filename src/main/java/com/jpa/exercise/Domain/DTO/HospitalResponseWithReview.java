package com.jpa.exercise.Domain.DTO;

import com.jpa.exercise.Domain.Hospital;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
// 병원 정보 + 리뷰 내용
public class HospitalResponseWithReview {
    private Long id;
    private String roadNameAddress;
    private String hospitalName;
    // 해당 병원에 대한 리뷰들의 정보
    private List<ReviewReadResponse> reviews;

    // Entity에서 값을 가져와 원하는 DTO 구조로 변환
    public static HospitalResponseWithReview fromEntity(Hospital hospital){
        return HospitalResponseWithReview.builder()
                .id(hospital.getId())
                .hospitalName(hospital.getHospitalName())
                .roadNameAddress(hospital.getRoadNameAddress())
                // reviews는 이미 hospital와 연결이 되어 있는 Review의 데이터를 가져와 맵핑한다
                .reviews(hospital.getReviews().stream()
                        .map(review -> ReviewReadResponse.fromEntity(review)).collect(Collectors.toList())) // review를 ReviewReadResponse로
                .build();
    }
}
