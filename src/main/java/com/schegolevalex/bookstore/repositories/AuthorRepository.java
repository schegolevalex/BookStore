package com.schegolevalex.bookstore.repositories;

import com.schegolevalex.bookstore.entities.Author;
import com.schegolevalex.bookstore.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AuthorRepository extends JpaRepository<Author, UUID> {
}
