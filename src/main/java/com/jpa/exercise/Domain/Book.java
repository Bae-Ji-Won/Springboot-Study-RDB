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
    
     private Long authorId;
     // => 다른 DB와 Join하여 데이터 호출
    // JPA가 Foreign Key를 걸어준다.
//    @ManyToOne
//    @JoinColumn(name = "author_id")
//    private Author author;
}