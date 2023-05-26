package com.schegolevalex.bookstore.controllers;

import com.schegolevalex.bookstore.gen.controllers.BooksApi;
import com.schegolevalex.bookstore.gen.models.BookFullViewDTO;
import com.schegolevalex.bookstore.gen.models.BookPatchRequestDTO;
import com.schegolevalex.bookstore.services.BookServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;
import java.util.UUID;

@RestController
@RequestMapping("/v1")
public class BookController implements BooksApi {
    private final BookServiceImpl bookService;

    public BookController(BookServiceImpl bookService) {
        this.bookService = bookService;
    }
    @Override
    public ResponseEntity<Set<BookFullViewDTO>> getAllBooks() {
        return ResponseEntity.ok(bookService.getAllBookFullViewDTOs());
    }





    @Override
    public ResponseEntity<BookFullViewDTO> createBook(BookFullViewDTO bookFullViewDTO) {
        return BooksApi.super.createBook(bookFullViewDTO);
    }

    @Override
    public ResponseEntity<Object> deleteBookById(UUID id) {
        return BooksApi.super.deleteBookById(id);
    }

    @Override
    public ResponseEntity<BookFullViewDTO> fullUpdateBookById(UUID id, BookFullViewDTO bookFullViewDTO) {
        return BooksApi.super.fullUpdateBookById(id, bookFullViewDTO);
    }

    @Override
    public ResponseEntity<BookFullViewDTO> getBookById(UUID id) {
        return BooksApi.super.getBookById(id);
    }

    @Override
    public ResponseEntity<BookFullViewDTO> partialUpdateBookById(UUID id, BookPatchRequestDTO bookPatchRequestDTO) {
        return BooksApi.super.partialUpdateBookById(id, bookPatchRequestDTO);
    }
}
