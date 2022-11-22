package com.sda.gabrielm.bookmanagement.service;

import com.sda.gabrielm.bookmanagement.model.Book;
import com.sda.gabrielm.bookmanagement.service.exceptions.EntityNotFoundException;
import com.sda.gabrielm.bookmanagement.service.exceptions.InvalidParameterException;

import java.util.List;

public interface BookService {
    default void createBook(String title, String description, int authorId)
            throws InvalidParameterException, EntityNotFoundException {

    }

    List<Book> getAllBooks();
}
