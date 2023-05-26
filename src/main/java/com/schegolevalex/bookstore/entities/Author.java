package com.schegolevalex.bookstore.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "authors")
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@ToString
@EqualsAndHashCode(of = "id")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column
    UUID id;
    @Column(name = "first_name")
    String firstName;
    @Column(name = "last_name")
    String lastName;
    @Column(name = "birthday")
    LocalDate birthday;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "books_authors"
            , joinColumns = @JoinColumn(name = "author_id")
            , inverseJoinColumns = @JoinColumn(name = "book_id"))
    List<Book> books;

    public void addBook(Book book) {
        if (books.isEmpty())
            books = new ArrayList<>();
        books.add(book);
    }
}
