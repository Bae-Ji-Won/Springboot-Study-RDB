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
                .map(book ->{
                    // 위에 찾은 전체 데이터인 books에는 id,bookname,authorid 3개의 데이터로 모든 데이터가 리스트로 저장이 되 있다.
                    // 그 중에서 authorid인 부분의 값을 가져와 authorRepository를 통해 author DB에서 데이터를 찾아와
                    // BookResponse의 of메서드(Builder)를 통해 데이터를 매칭 시켜서 반환해준다.
                    // 현재 이 방법은 DB에서 Join을 사용하지 않고 Jpa에서 데이터를 각자 찾아 Build를 통해 데이터를 삽입하는 방식이다.
                    Optional<Author> optionalAuthor = authorRepository.findById(book.getAuthorId());
                    return BookResponse.of(book,optionalAuthor.get().getName());
                }).collect(Collectors.toList());
        return bookResponses;
    }
}
