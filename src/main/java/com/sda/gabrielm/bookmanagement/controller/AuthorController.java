package com.sda.gabrielm.bookmanagement.controller;

import com.sda.gabrielm.bookmanagement.service.AuthorService;
import com.sda.gabrielm.bookmanagement.service.exceptions.EntityNotFoundException;
import com.sda.gabrielm.bookmanagement.service.exceptions.InvalidParameterException;

import java.io.IOException;
import java.nio.channels.ScatteringByteChannel;
import java.util.Scanner;

public class AuthorController {
    private final AuthorService authorService;
    private final Scanner scanner = new Scanner(System.in);

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    public void createAuthor() throws InvalidParameterException {
        try {
            System.out.println("Please insert an author first name");
            String firstName = scanner.nextLine();

            System.out.println("Please insert an author last name");
            String lastName = scanner.nextLine();

            authorService.createAuthor(firstName, lastName);
            System.out.println("Author was  created!");
        } catch (InvalidParameterException e) {
            System.out.println(e.getMessage());
        } catch (Exception ex) {
            System.out.println("Internal server error");
        }
    }

    public void updateAuthor() {
        try {
            System.out.println("Please insert an author id ! ");
            int authorId = Integer.parseInt(scanner.nextLine());
            System.out.println("Please insert an author first name");
            String firstName = scanner.nextLine();
            System.out.println("Please insert an author last name");
            String lastName = scanner.nextLine();
            authorService.updateAuthor(authorId, firstName, lastName);
            System.out.println("Author was updated");
        } catch (InvalidParameterException | EntityNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Provided author Id is not a number");
        } catch (Exception e) {
            System.out.println("Internal server error");
        }
    }

    public void deleteAuthor() {
        try {
            System.out.println(" please insert author id! ");
            int authorId = Integer.parseInt(scanner.nextLine());
            authorService.deleteAuthor(authorId);
        } catch (NumberFormatException e) {
            System.out.println("Provided author Id is not a number");
        } catch (InvalidParameterException e) {
            System.out.println(e.getMessage());
        } catch (EntityNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Internal server error");
        }
    }

    public void importAuthors() {
        try {
            System.out.println("Author import started! ");
            authorService.importAuthors();
            System.out.println("Author import finished ");
        } catch (IOException e) {
            System.out.println("Internal server error, import failed! ");
        }
    }


    public void showAllAuthors() {
        authorService.getAllAuthors().stream().forEach(author ->
                System.out.println("Author with id: "
                        + author.getId()
                        + " lastname "
                        + author.getLastname()
                        + " firstname "
                        + author.getFirstname()
                ));
    }
}
