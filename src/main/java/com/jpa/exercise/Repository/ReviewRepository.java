package com.jpa.exercise.Repository;

import com.jpa.exercise.Domain.DTO.ReviewReadResponse;
import com.jpa.exercise.Domain.Hospital;
import com.jpa.exercise.Domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review,Long> {
    List<ReviewReadResponse> findByHospital(Hospital hospital);
}
