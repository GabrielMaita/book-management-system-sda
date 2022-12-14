package com.sda.gabrielm.bookmanagement.repository;

import com.sda.gabrielm.bookmanagement.model.Book;

import java.util.Optional;

public interface BookRepository extends BaseRepository<Book>{
    Optional<Book> findByTitle(String title);
}