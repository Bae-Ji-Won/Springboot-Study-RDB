package com.jpa.exercise.Service;

import com.jpa.exercise.Domain.Author;
import com.jpa.exercise.Domain.Book;
import com.jpa.exercise.Domain.DTO.BookResponse;
import com.jpa.exercise.Repository.AuthorRepository;
import com.jpa.exercise.Repository.BookRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookService(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    
    public Page<Book> TotalList(Pageable pageable){
        return bookRepository.findAll(pageable);
    }
    
    // Json 형식으로 반환
    public List<BookResponse> jsonList(Pageable pageable){
        Page<Book> books = bookRepository.findAll(pageable);
        List<BookResponse> bookResponses = books.stream()
            .map(book -> BookResponse.of(book)).collect(Collectors.toList());   // books에 있는 데이터를 book으로 리스트 1개씩 전부 받아 BookResponse.of로 보내어 준다.
        return bookResponses;
    }
}
