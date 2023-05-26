package com.schegolevalex.bookstore.controllers;

import com.schegolevalex.bookstore.entities.Book;
import com.schegolevalex.bookstore.gen.controllers.BooksApi;
import com.schegolevalex.bookstore.gen.models.BookFullViewDTO;
import com.schegolevalex.bookstore.services.BookServiceImpl;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1")
public class BookController implements BooksApi {
    private final BookServiceImpl bookService;
    private final ModelMapper modelMapper;

    public BookController(BookServiceImpl bookService, ModelMapper modelMapper) {
        this.bookService = bookService;
        this.modelMapper = modelMapper;
    }

    @Override
    public ResponseEntity<Set<BookFullViewDTO>> getAllBooks() {
        TypeMap<Book, BookFullViewDTO> bookMapper = modelMapper.createTypeMap(Book.class, BookFullViewDTO.class);
        bookMapper.addMappings(mapper -> mapper.map(src -> src.getYear().getYear(), BookFullViewDTO::setPublicationYear));

        Set<BookFullViewDTO> responseBody = bookService.getAllBooks().stream()
                .map(book -> modelMapper.map(book, BookFullViewDTO.class))
                .collect(Collectors.toSet());
        return ResponseEntity.ok(responseBody);
    }
}
