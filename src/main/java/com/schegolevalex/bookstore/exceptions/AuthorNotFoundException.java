package com.schegolevalex.bookstore.exceptions;

public class AuthorNotFoundException extends RuntimeException {
    public AuthorNotFoundException(String s) {
        super(s);
    }
}
