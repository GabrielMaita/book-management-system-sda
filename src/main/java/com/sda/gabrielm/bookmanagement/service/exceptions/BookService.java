package com.sda.gabrielm.bookmanagement.service.exceptions;

public interface BookService {
    default void createBook(String title, String description, int authorId)
            throws InvalidParameterException, EntityNotFoundException {

    }
}
