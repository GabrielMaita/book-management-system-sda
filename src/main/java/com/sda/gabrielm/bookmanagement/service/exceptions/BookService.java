package com.sda.gabrielm.bookmanagement.service.exceptions;

import java.util.Arrays;

public interface BookService {
    default void createBook(String title, String description, int authorId)
            throws InvalidParameterException, EntityNotFoundException {

    }

    Arrays getAllBooks();
}
