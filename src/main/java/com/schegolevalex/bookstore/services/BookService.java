package com.schegolevalex.bookstore.services;

import com.schegolevalex.bookstore.gen.models.BookFullViewDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.UUID;

@Service
public interface BookService {

    @Transactional
    Set<BookFullViewDTO> getAllBookFullViewDTOs();

    @Transactional
    BookFullViewDTO getBookFullViewDTOById(UUID uuid);
}
