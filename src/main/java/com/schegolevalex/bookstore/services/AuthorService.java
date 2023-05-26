package com.schegolevalex.bookstore.services;

import com.schegolevalex.bookstore.entities.Author;
import com.schegolevalex.bookstore.entities.Book;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface AuthorService {
    List<Author> getAllAuthors();

    Author getAuthorById(UUID uuid);
}
