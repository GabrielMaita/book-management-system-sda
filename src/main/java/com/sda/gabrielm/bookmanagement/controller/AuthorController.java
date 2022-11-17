package com.sda.gabrielm.bookmanagement.controller;

import com.sda.gabrielm.bookmanagement.service.AuthorService;
import com.sda.gabrielm.bookmanagement.service.exceptions.InvalidParameterException;

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

    public void showAllAuthors(){
        authorService.getAllAuthors().stream().forEach(author ->
                        System.out.println("Author with id: "
                                + author.getId()
                                + " lastname "
                                + author.getLastname()
                                +" firstname "
                                + author.getFirstname()
                ));
    }
}
