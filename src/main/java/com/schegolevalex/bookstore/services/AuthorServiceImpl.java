package com.schegolevalex.bookstore.services;

import com.schegolevalex.bookstore.entities.Author;
import com.schegolevalex.bookstore.entities.Book;
import com.schegolevalex.bookstore.exceptions.AuthorNotFoundException;
import com.schegolevalex.bookstore.exceptions.BookNotFoundException;
import com.schegolevalex.bookstore.repositories.AuthorRepository;
import com.schegolevalex.bookstore.repositories.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public Author getAuthorById(UUID uuid) {
        Optional<Author> author = authorRepository.findById(uuid);
        if (author.isPresent()) {
            return author.get();
        } else
            throw new AuthorNotFoundException("Author with id = " + uuid + " not found in database");
    }
}
