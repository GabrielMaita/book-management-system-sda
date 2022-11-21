package com.sda.gabrielm.bookmanagement.service.exceptions;

import com.sda.gabrielm.bookmanagement.model.Author;
import com.sda.gabrielm.bookmanagement.model.Book;
import com.sda.gabrielm.bookmanagement.repository.AuthorRepository;
import com.sda.gabrielm.bookmanagement.repository.BookRepository;

import java.util.List;
import java.util.Optional;


public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }
    @Override
    public void createBook(String title, String description, int authorId) throws EntityNotFoundException, InvalidParameterException {
        if (title == null || title.isBlank() || title.length() < 3) {
            throw new InvalidParameterException("Provided value for title: " + title + " is invalid");
        }
        if (description == null || description.isBlank() || description.length() < 10) {
            throw new InvalidParameterException("Provided value for description: " + description + " is invalid");
        }
        if (authorId < 1) {
            throw new InvalidParameterException("Provided value for author id: " + authorId + " is invalid");
        }
        Optional<Author> authorOptional = authorRepository.findById(authorId);
        if (authorOptional.isEmpty()) {
            throw new EntityNotFoundException("Author with provided id " + authorId + " was not found!");
        }
        Author author = authorOptional.get();
        Book book = new Book(title, description);
        book.setAuthor(author);
        bookRepository.create(book);
    }
    public List<Book> getAllBooks () {
        return bookRepository.findAll();
    }
}


