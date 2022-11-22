package com.sda.gabrielm.bookmanagement;

import com.sda.gabrielm.bookmanagement.controller.AuthorController;
import com.sda.gabrielm.bookmanagement.controller.BookController;
import com.sda.gabrielm.bookmanagement.controller.ReviewController;
import com.sda.gabrielm.bookmanagement.menu.UserOption;
import com.sda.gabrielm.bookmanagement.repository.AuthorRepositoryImpl;
import com.sda.gabrielm.bookmanagement.repository.BookRepositoryImpl;
import com.sda.gabrielm.bookmanagement.repository.BookReviewRepositoryImpl;
import com.sda.gabrielm.bookmanagement.service.AuthorServiceImpl;
import com.sda.gabrielm.bookmanagement.service.BookReviewServiceImpl;
import com.sda.gabrielm.bookmanagement.service.BookServiceImpl;
import com.sda.gabrielm.bookmanagement.service.exceptions.EntityNotFoundException;
import com.sda.gabrielm.bookmanagement.service.exceptions.InvalidParameterException;
import com.sda.gabrielm.bookmanagement.utils.SessionManager;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws EntityNotFoundException, InvalidParameterException {
        SessionManager.getSessionFactory();
        AuthorController authorController = new AuthorController(new AuthorServiceImpl(new AuthorRepositoryImpl()));
        BookController bookController = new BookController(new BookServiceImpl(new BookRepositoryImpl(), new AuthorRepositoryImpl()));
        ReviewController reviewController = new ReviewController(new BookReviewServiceImpl( new BookReviewRepositoryImpl(), new BookRepositoryImpl()));

        Scanner scanner = new Scanner(System.in);

        UserOption userOption;
        do {
            UserOption.printAllOptions();
            System.out.println("Please select an option!");
            try {
                int numericOption = Integer.parseInt(scanner.nextLine());
                userOption = UserOption.findUserOption(numericOption);
            } catch (NumberFormatException e) {
                userOption = UserOption.UNKNOWN;
            }
            switch (userOption) {
                case CREATE_AUTHOR:
                    authorController.createAuthor();
                    break;
                case SHOW_ALL_AUTHORS:
                    authorController.showAllAuthors();
                    break;
                case UPDATE_AUTHOR:
                    authorController.updateAuthor();
                    break;
                case DELETE_AUTHOR:
                    authorController.deleteAuthor();
                    break;
                case CREATE_BOOK:
                    bookController.createBook();
                    break;
                case SHOW_ALL_BOOKS:
                    bookController.showAllBooks();
                    break;
                case CREATE_REVIEW:
                    reviewController.createReview();
                    break;
                case EXIT:
                    System.out.println("Goodbye!");
                    break;
                case UNKNOWN:
                    System.out.println("Option unknown!");
                    break;
                default:
                    System.out.println("User option " + userOption + " is not implemented!");
                    break;
            }
        } while (userOption != UserOption.EXIT);
        SessionManager.shutDown();
    }
}