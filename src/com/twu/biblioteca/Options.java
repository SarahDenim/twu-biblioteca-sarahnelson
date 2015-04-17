package com.twu.biblioteca;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sarahnelson on 18/04/2015.
 */
public class Options {

    private List<Book> bookList = new ArrayList<Book>();

    public void welcomeMessage() throws IOException {
        System.out.println("Welcome to Biblioteca! We're ready to rumble!");
    }

    public void mainMenu() throws IOException {
        System.out.println("Main menu: \n1. List Books \n2. Checkout book \n" +
                "3. Return book \n\nCommands (use at any time) \nm: show main menu " +
                "\nq: quit");
    }

    public void listBooks() throws IOException {
        for (Book b:bookList){
            if(b.isCheckedIn()){
                System.out.print(b.getName() + " by ");
                System.out.print(b.getAuthor() + ", ");
                System.out.println(b.getYearPublished());
            }
        }
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
            if (b.getName().equals(input) && (b.isCheckedIn())) {
                b.checkOut();
                System.out.println("Thank you! Enjoy the book");
                success = true;
            }
        }
        if (!success) {
            System.out.println("That book is not available.");
        }
    }

    public void returnBook(String input) {
        boolean success = false;
        for(Book b:bookList) {
            if (b.getName().equals(input) && (!b.isCheckedIn())) {
                b.checkIn();
                System.out.println("Thank you for returning the book.");
                success = true;
            }
        }
        if (!success) {
            System.out.println("That is not a valid book to return.");
        }
    }
}
