package com.jpa.exercise.Domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class Hospital {
    @Id
    private Long id;
    private String roadNameAddress;
    private String hospitalName;

    /*
    JPA에서는 데이터를 조회할 때 즉시 로딩(EAGER)과 지연 로딩(LAZY) 두 가지 방식이 있다.
    이 두 가지 방식을 간단하게 설명하면 즉시 로딩은 데이터를 조회할 때 연관된 데이터까지 한 번에 불러오는 것이고,
    지연 로딩은 필요한 시점에 연관된 데이터를 불러오는 것이라고 할 수 있다.
    가급적이면 기본적으로 지연 로딩을 사용하는 것이 좋다.
     */
    @OneToMany(mappedBy = "hospital", fetch = FetchType.LAZY)
    // 병원은 1개이고 리뷰는 여러개 달리므로 One = 병원, Many = 리뷰들
    // mappedBy를 통해 Review에서 연관맵핑으로 선언한 hospital 객체와 연동한다고 설정을 해준다.
    private List<Review> reviews;
}