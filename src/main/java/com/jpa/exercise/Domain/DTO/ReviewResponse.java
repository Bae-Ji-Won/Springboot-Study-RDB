package com.jpa.exercise.Domain.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
// 리뷰를 생성할때 반환하는 데이터
public class ReviewResponse {
    private Long id;
    private String title;
    private String content;
    private String userName;
    private String message;
}
