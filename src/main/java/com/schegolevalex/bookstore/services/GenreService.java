package com.schegolevalex.bookstore.services;

import com.schegolevalex.bookstore.entities.Author;
import com.schegolevalex.bookstore.entities.Genre;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface GenreService {
    List<Genre> getAllGenres();

    Genre getGenreById(UUID uuid);
}
