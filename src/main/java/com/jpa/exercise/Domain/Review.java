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
    private Long id;

    private String title;
    private String content;
    private String userName;

    @ManyToOne      // 리뷰입장에서는 리뷰가 여러개고 병원은 한개이므로
    @JoinColumn(name = "hospital_id")   // hospital_id의 행을 hospital의 pk를 가르키도록 함
    private Hospital hospital;          // 즉, hospital_id가 FK가 됨

}
