package com.schegolevalex.bookstore.exceptions;

import com.schegolevalex.bookstore.entities.Book;

import java.util.List;

public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(String s) {
        super(s);
    }
}
