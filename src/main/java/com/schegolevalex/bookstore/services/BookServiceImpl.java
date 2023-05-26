package com.schegolevalex.bookstore.services;

import com.schegolevalex.bookstore.entities.Book;
import com.schegolevalex.bookstore.exceptions.BookNotFoundException;
import com.schegolevalex.bookstore.gen.models.BookFullViewDTO;
import com.schegolevalex.bookstore.repositories.BookRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final ModelMapper modelMapper;
    public BookServiceImpl(BookRepository bookRepository, ModelMapper modelMapper) {
        this.bookRepository = bookRepository;
        this.modelMapper = modelMapper;
    }
    private List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
    private Book getBookById(UUID uuid) {
        Optional<Book> book = bookRepository.findById(uuid);
        if (book.isPresent()) {
            return book.get();
        } else
            throw new BookNotFoundException("Book with id = " + uuid + " not found in database");
    }
    @Override
    @Transactional
    public Set<BookFullViewDTO> getAllBookFullViewDTOs() {
        return getAllBooks().stream()
                .map(book -> modelMapper.map(book, BookFullViewDTO.class))
                .collect(Collectors.toSet());
    }

    @Override
    @Transactional
    public BookFullViewDTO getBookFullViewDTOById(UUID uuid) {
        return modelMapper.map(getBookById(uuid), BookFullViewDTO.class);
    }
}
