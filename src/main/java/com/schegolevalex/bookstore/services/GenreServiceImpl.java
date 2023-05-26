package com.schegolevalex.bookstore.services;

import com.schegolevalex.bookstore.entities.Book;
import com.schegolevalex.bookstore.entities.Genre;
import com.schegolevalex.bookstore.exceptions.BookNotFoundException;
import com.schegolevalex.bookstore.exceptions.GenreNotFoundException;
import com.schegolevalex.bookstore.repositories.BookRepository;
import com.schegolevalex.bookstore.repositories.GenreRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class GenreServiceImpl implements GenreService {
    private final GenreRepository genreRepository;

    public GenreServiceImpl(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @Override
    public List<Genre> getAllGenres() {
        return genreRepository.findAll();
    }

    @Override
    public Genre getGenreById(UUID uuid) {
        Optional<Genre> genre = genreRepository.findById(uuid);
        if (genre.isPresent()) {
            return genre.get();
        } else
            throw new GenreNotFoundException("Genre with id = " + uuid + " not found in database");
    }
}
