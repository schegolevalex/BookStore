package com.schegolevalex.bookstore.services;

import com.schegolevalex.bookstore.entities.Book;
import com.schegolevalex.bookstore.exceptions.BookNotFoundException;
import com.schegolevalex.bookstore.repositories.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BookServiceImpl implements BookService {
    private final
    BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book getBookById(UUID uuid) {
        Optional<Book> book = bookRepository.findById(uuid);
        if (book.isPresent()) {
            return book.get();
        } else
            throw new BookNotFoundException("Book with id = " + uuid + " not found in database");
    }
}
