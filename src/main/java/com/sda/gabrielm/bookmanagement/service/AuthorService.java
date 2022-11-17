package com.sda.gabrielm.bookmanagement.service;

import com.sda.gabrielm.bookmanagement.model.Author;
import com.sda.gabrielm.bookmanagement.service.exceptions.InvalidParameterException;

import java.util.List;

public interface AuthorService {

    void createAuthor(String firstName, String lastName) throws InvalidParameterException;

    List<Author> getAllAuthors ();

}
