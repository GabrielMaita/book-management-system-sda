package com.sda.gabrielm.bookmanagement.service;

import com.sda.gabrielm.bookmanagement.model.Book;
import com.sda.gabrielm.bookmanagement.service.exceptions.EntityNotFoundException;
import com.sda.gabrielm.bookmanagement.service.exceptions.InvalidParameterException;

import java.util.List;


public interface BookReviewService {
    void createBookReview(String bookTitle, int score, String comment)
            throws InvalidParameterException, EntityNotFoundException;
}

