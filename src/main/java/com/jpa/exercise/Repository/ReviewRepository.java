package com.jpa.exercise.Repository;

import com.jpa.exercise.Domain.DTO.ReviewReadResponse;
import com.jpa.exercise.Domain.Hospital;
import com.jpa.exercise.Domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review,Long> {
    List<Review> findByHospital(Hospital hospital);
    // 현재 게시물의 ID를 입력받고 그 ID를 통해 Hospital의 DB에서 데이터를 찾아 그 데이터 중 hospital_id의 값을 가지고
    // findByHospital(hospital_id)을 통해 Review DB에서 해당 hospital_id를 가진 값들을 모두 찾아낸다.
}
