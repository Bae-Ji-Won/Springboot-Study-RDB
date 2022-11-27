package com.jpa.exercise.Domain.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class ReviewRequest {
//    private Integer hospitalId;
    private String title;
    private String content;
    private String userName;
}
