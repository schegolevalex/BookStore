package com.schegolevalex.bookstore.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
@Entity
@Table(name = "books")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class Book {
    @Id
    @Column(name = "id")
    long id;
    @Column(name = "title")
    String title;
    @Column(name = "year")
    LocalDate year;
    @Column(name = "total_pages")
    int totalPages;
//    @Column(name = "authors")
//    List<Author> authors;
//    @Column(name = "genres")
//    List<Genre> genres;
}
