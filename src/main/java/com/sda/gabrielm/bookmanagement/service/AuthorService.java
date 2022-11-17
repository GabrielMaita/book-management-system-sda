package com.sda.gabrielm.bookmanagement.service;

import com.sda.gabrielm.bookmanagement.service.exceptions.InvalidParameterException;

public interface AuthorService {

    void createAuthor(String firstName, String lastName) throws InvalidParameterException;
}
