package com.jpa.exercise.Domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "book")
@AllArgsConstructor
@NoArgsConstructor
public class Book {
        @Id
        private Long id;
        private String name;

        // JPA가 Foreign Key를 걸어준다.
        @ManyToOne                      // 단방향(한개 이상의 데이터를 호출할 수 있으므로, 저자가 여러명)
        @JoinColumn(name = "author_id") // Book DB의 author_id와 아래의 변수를 Join시킴(즉, 아래의 변수를 FK로 만들어준다)
        private Author author;      // Author 테이블을 호출함

        @OneToOne                       // 단방향(무조건 한개의 데이터만 호출할 수 있으므로, 출판사는 한곳에서만)
        @JoinColumn(name = "publisher_id")  // publisher_id를 Publisher의 FK로 연결함
        private Publisher publisher;
}