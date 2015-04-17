package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BibliotecaApp {

    private List<Book> bookList = new ArrayList<Book>();

    public static void main(String[] args) throws IOException {
        BibliotecaApp app = new BibliotecaApp();
    }

    public BibliotecaApp() throws IOException {
        setUpBookList();
        welcomeMessage();
        mainMenu();
        runCommand(checkInput());
    }

    public char checkInput() throws IOException {
        System.out.println("\nWhat would you like to do?");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //check if input is a command

        String input = br.readLine();

        if(input.equals("q")) {
            return 'q';
        }
        else if (input.equals("m")) {
            return 'm';
        }
        else {
            //check if input is a number (selecting menu item) or a command
            int inputInt;

            try {
                //check if input is an integer
                inputInt = Integer.parseInt(input);
                if (inputInt == 1) {
                    return 1;
                    //call list books method
                } else {
                    System.err.println("Enter valid menu item number");
                    runCommand(checkInput());
                }
            } catch (NumberFormatException nfe) {
                System.err.println("Invalid Command");
                runCommand(checkInput());
            }
        }
        return 0;
    }

    public void runCommand(char command) throws IOException {
        switch (command) {
            case 'm':
                mainMenu();
                runCommand(checkInput());
                break;
            case 'q':
                quit();
                runCommand(checkInput());
                break;
            case 1:
                listBooks();
                runCommand(checkInput());
        }
    }

    public void listBooks() throws IOException {
        System.out.println(bookList);
    }

    public static void quit() throws IOException {
        //quit program
        System.out.println("Quitting program");
    }

    public void welcomeMessage() throws IOException {
        System.out.println("Welcome to Biblioteca! We're ready to rumble!");
    }

    public void mainMenu() throws IOException {
        System.out.println("Main menu: \n1. List Books \n2. Checkout book \n" +
                "3. Return book \n\nCommands (use at any time) \nm: show main menu " +
                "\nq: quit");
    }

    public void setUpBookList() {

        Book Gatsby = new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925);
        Book Rings = new Book("The Lord of the Rings", "J.R.R. Tolkien", 1954);

        bookList.add(Gatsby);
        bookList.add(Rings);
    }
}
