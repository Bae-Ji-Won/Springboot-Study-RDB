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
                private String PublisherName;

                public static BookResponse of(Book book){
                        return BookResponse.builder()
                                .BookId(book.getId())
                                .BookName(book.getName())
                                .AuthorName(book.getAuthor().getName())    // Author Entity의 이름을 가져옴
                                .PublisherName(book.getPublisher().getName())   // Publisher Entity의 이름을 가져옴
                                .build();
                }
        }
