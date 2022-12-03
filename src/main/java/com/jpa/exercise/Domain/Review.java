package com.jpa.exercise.Domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;            // 리뷰 id

    private String title;       // 리뷰 제목
    private String content;     // 리뷰 내용
    private String userName;    // 리뷰 작성자

    @ManyToOne      // 리뷰입장에서는 리뷰가 여러개고 병원은 한개이므로
    @JoinColumn(name = "hospital_id")   // hospital_id의 행을 Hospital DB와 연결함
    private Hospital hospital;          // 즉, hospital_id가 FK가 됨
}
