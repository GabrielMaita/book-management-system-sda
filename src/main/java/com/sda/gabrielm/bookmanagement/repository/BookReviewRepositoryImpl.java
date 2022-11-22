package com.sda.gabrielm.bookmanagement.repository;

import com.sda.gabrielm.bookmanagement.model.Book;
import com.sda.gabrielm.bookmanagement.model.Review;

import java.util.List;
import java.util.Optional;

public class BookReviewRepositoryImpl extends BaseRepositoryImpl<Review> implements BookReviewRepository {
    public BookReviewRepositoryImpl() {
        super(Review.class);
    }
}