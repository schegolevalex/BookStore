package com.schegolevalex.bookstore.repositories;

import com.schegolevalex.bookstore.entities.Book;
import com.schegolevalex.bookstore.entities.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface GenreRepository extends JpaRepository<Genre, UUID> {
}
