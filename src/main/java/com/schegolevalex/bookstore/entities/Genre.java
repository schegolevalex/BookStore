package com.schegolevalex.bookstore.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "genres")
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@ToString(exclude = "books")
@EqualsAndHashCode(of = "id")
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID id;
    @Column(name = "name")
    String name;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "books_genres"
            , joinColumns = @JoinColumn(name = "genre_id")
            , inverseJoinColumns = @JoinColumn(name = "book_id"))
    List<Book> books;

    public void addBook(Book book) {
        if (books.isEmpty())
            books = new ArrayList<>();
        books.add(book);
    }
}
