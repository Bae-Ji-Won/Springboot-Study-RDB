package com.jpa.exercise.Repository;

import com.jpa.exercise.Domain.Book;
import com.jpa.exercise.Domain.DTO.BookResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {

}
