package com.jpa.exercise.Domain.DTO;

import com.jpa.exercise.Domain.Book;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class BookResponse {
        private long BookId;
        private String BookName;
        private String AuthorName;

        public static BookResponse of(Book book,String authorName){
                return BookResponse.builder()
                        .BookId(book.getId())
                        .BookName(book.getName())
                        .AuthorName(authorName)
                        .build();
        }
}
