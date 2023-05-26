package com.schegolevalex.bookstore.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "books")
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@ToString(exclude = {"authors", "genres"})
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    UUID id;
    @Column(name = "title")
    String title;
    @Column(name = "year")
    LocalDate year;
    @Column(name = "total_pages")
    int totalPages;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "books_authors"
            , joinColumns = @JoinColumn(name = "book_id")
            , inverseJoinColumns = @JoinColumn(name = "author_id"))
    List<Author> authors;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "books_genres"
            , joinColumns = @JoinColumn(name = "book_id")
            , inverseJoinColumns = @JoinColumn(name = "genre_id"))
    List<Genre> genres;

    public void addAuthor(Author author) {
        if (authors.isEmpty())
            authors = new ArrayList<>();
        authors.add(author);
    }

    public void addGenre(Genre genre) {
        if (genres.isEmpty())
            genres = new ArrayList<>();
        genres.add(genre);
    }

//    @Override
//    public String toString() {
//        return "Book{" +
//                "id=" + id +
//                ", title='" + title + '\'' +
//                ", year=" + year +
//                ", totalPages=" + totalPages +
//                '}';
//    }
}
