package com.sda.gabrielm.bookmanagement.repository;


import com.sda.gabrielm.bookmanagement.model.Book;
import com.sda.gabrielm.bookmanagement.utils.SessionManager;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BookRepositoryImpl<T> extends BaseRepositoryImpl<Book> implements BaseRepository<T> {
    public BookRepositoryImpl() {
        super(Book.class);
    }
}
