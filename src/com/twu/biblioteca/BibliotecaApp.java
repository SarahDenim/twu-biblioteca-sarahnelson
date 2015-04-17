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
        app.start();
    }

    public BibliotecaApp() {

    }

    public void start () throws IOException {
        setUpBookList();
        welcomeMessage();
        mainMenu();

        while(true) {
            char input = checkInput();
            if(input == 'q') break;
            runCommand(input);
        }
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
                }
                else if (inputInt == 2) {
                    return 2;
                }
                else if (inputInt == 3) {
                    return 3;
                }
                else {
                    System.err.println("Enter valid menu item number");
                }
            } catch (NumberFormatException nfe) {
                System.err.println("Invalid Command");
            }
        }
        return 0;
    }

    public void runCommand(char command) throws IOException {
        switch (command) {
            case 'm':
                mainMenu();
                //runCommand(checkInput());
                break;
            case 'q':
                quit();
                //runCommand(checkInput());
                break;
            case 1:
                listBooks();
                //runCommand(checkInput());
                break;
            case 2:
                System.out.println("Which book do you wish to check out?");
                BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
                String input1 = br1.readLine();
                checkoutBook(input1);
                break;
            case 3:
                System.out.println("Which book do you wish to return?");
                BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
                String input2 = br2.readLine();
                returnBook(input2);
                break;
        }
    }

    public void listBooks() throws IOException {
        for (Book b:bookList){
            if(b.isCheckedIn()){
                System.out.print(b.getName() + " by ");
                System.out.print(b.getAuthor() + ", ");
                System.out.println(b.getYear_published());
            }
        }
        //System.out.println(bookList);
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

    public void checkoutBook(String input) {
        boolean success = false;
        for(Book b:bookList) {
            if (b.getName().equals(input)) {
                b.checkOut();
                System.out.println("Thank you! Enjoy the book");
                success = true;
            }
            if (!success) {
                System.out.println("That book is not available.");
            }
        }
    }

    public void returnBook(String input) {
        boolean success = false;
        for(Book b:bookList) {
            if (b.getName().equals(input)) {
                b.checkIn();
                System.out.println("Thank you for returning the book.");
                success = true;
            }
            if (!success) {
                System.out.println("That is not a valid book to return.");
            }
        }
    }
}