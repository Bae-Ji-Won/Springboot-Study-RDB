package com.jpa.exercise.Service;

import com.jpa.exercise.Domain.Hospital;
import com.jpa.exercise.Repository.HospitalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HospitalService {
    private final HospitalRepository hospitalRepository;
    private final ReviewService reviewService;


    // 병원정보에 대한 데이터를 가져옴
    public Hospital findById(Long id){
        Hospital hospital = hospitalRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("id가 없습니다."));   // 값이 null일때 오류 출력
        return hospital;
    }
}
