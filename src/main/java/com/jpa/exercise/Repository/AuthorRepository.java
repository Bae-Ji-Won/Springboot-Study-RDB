package com.jpa.exercise.Repository;

import com.jpa.exercise.Domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author,Long> {
}
