package com.jpa.exercise.Controller;

import com.jpa.exercise.Domain.Book;
import com.jpa.exercise.Domain.DTO.BookResponse;
import com.jpa.exercise.Service.BookService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
    @RequestMapping("/api/v1/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    // List 형식으로 전체 출력(View로 데이터 넘길때 사용)
    @GetMapping("")
    public Page<Book> get(Pageable pageable){
        return bookService.TotalList(pageable);
    }

    // Json 형식으로 전체 출력
    @GetMapping("/json")
    public ResponseEntity<List<BookResponse>> JsonData(Pageable pageable){
        return ResponseEntity.ok().body(bookService.jsonList(pageable));
    }
}
