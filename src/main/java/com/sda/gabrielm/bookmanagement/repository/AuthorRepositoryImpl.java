package com.sda.gabrielm.bookmanagement.repository;

import com.sda.gabrielm.bookmanagement.model.Author;

public class AuthorRepositoryImpl extends  BaseRepositoryImpl<Author> implements AuthorRepository{
    public AuthorRepositoryImpl() {
        super(Author.class);
    }
}
