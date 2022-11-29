package com.jpa.exercise.Domain.DTO;

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
}
