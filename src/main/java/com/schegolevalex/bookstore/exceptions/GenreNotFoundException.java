package com.schegolevalex.bookstore.exceptions;

public class GenreNotFoundException extends RuntimeException {
    public GenreNotFoundException(String s) {
        super(s);
    }
}
