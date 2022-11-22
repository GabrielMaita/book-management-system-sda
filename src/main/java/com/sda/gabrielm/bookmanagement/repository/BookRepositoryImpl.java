package com.sda.gabrielm.bookmanagement.repository;

import com.sda.gabrielm.bookmanagement.model.Book;

import java.util.List;
import java.util.Optional;

public class BookRepositoryImpl extends BaseRepositoryImpl<Book> implements BookRepository {
    public BookRepositoryImpl() {
        super(Book.class);
    }
    @Override
    public Optional<Book> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public void create(Book entity) {

    }

    @Override
    public void update(Book entity) {

    }

    @Override
    public void delete(Book entity) {

    }

    @Override
    public List<Book> findAll() {
        return null;
    }

    @Override
    public Optional<Book> findByTitle(String title) {
        return Optional.empty();
    }
}
