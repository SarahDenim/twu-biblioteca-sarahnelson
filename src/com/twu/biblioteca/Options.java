package com.twu.biblioteca;

import java.io.*;

public class Options {

    private BufferedReader reader;
    private PrintStream writer;
    private Library library;
    private UserList userList;
    private boolean loggedIn = false;

    public Options(InputStream in, OutputStream out) {
        reader = new BufferedReader(new InputStreamReader(in));
        writer = new PrintStream(out);
        library = new Library();
        library.setUpBookList();
        library.setUpMovieList();
        userList = new UserList();
        userList.setUpUserList();
    }

    public void mainMenu() throws IOException {
        if(isLoggedIn()) {
            writer.println("Main Menu: \n1. List Books \n2. Checkout Book \n" +
                    "3. Return Book \n4. List Movies \n5. Show User Details \n\nCommands (use at any time) \nm: show main menu " +
                    "\nq: quit");
        }
        else {
            writer.println("Main Menu: \n1. List Books \n2. Checkout Book \n" +
                    "3. Return Book \n4. List Movies \n\nCommands (use at any time) \nm: show main menu " +
                    "\nq: quit");
        }
    }

    public void listBooks() throws IOException {
        for (Book b:library.getCheckedInBooks()) {
            writer.print(b.getName() + " by ");
            writer.print(b.getAuthor() + ", ");
            writer.println(b.getYearPublished());
        }
    }

    public void listMovies() {
        for (Movie m:library.getCheckedInMovies()) {
            writer.print(m.getName() + " by ");
            writer.print(m.getDirector() + ", ");
            writer.print(m.getYear() + ", ");
            if (m.getRating() == 0) {
                writer.println("unrated");
            }
            else {
                writer.println(m.getRating());
            }
        }
    }

    public void checkoutBook() throws IOException {

        writer.println("Which book do you wish to check out?");
        String book = reader.readLine();

        boolean success = false;
        for(Book b:library.getCheckedInBooks()) {
            if (b.getName().equals(book)) {
                b.checkOut();
                writer.println("Thank you! Enjoy the book.");
                success = true;
            }
        }
        if (!success) {
            writer.println("That book is not available.");
        }
    }

    public void checkoutMovie() throws IOException {
        writer.println("Which movie do you wish to check out?");
        String movie = reader.readLine();

        boolean success = false;
        for(Movie m:library.getCheckedInMovies()) {
            if (m.getName().equals(movie)) {
                m.checkOut();
                writer.println("Thank you! Enjoy the movie.");
                success = true;
            }
        }
        if (!success) {
            writer.println("That movie is not available.");
        }
    }

    public void returnBook() throws IOException {
        writer.println("Which book do you wish to return?");
        String book = reader.readLine();

        boolean success = false;
        for(Book b:library.getCheckedOutBooks()) {
            if (b.getName().equals(book)) {
                b.checkIn();
                writer.println("Thank you for returning the book.");
                success = true;
            }
        }
        if (!success) {
            writer.println("That is not a valid book to return.");
        }
    }

    public void returnMovie() throws IOException {
        writer.println("Which movie do you wish to return?");
        String movie = reader.readLine();

        boolean success = false;

        for(Movie m:library.getCheckedOutMovies()) {
            if (m.getName().equals(movie)) {
                m.checkIn();
                writer.println("Thank you for returning the movie.");
                success = true;
            }
        }

        if (!success) {
            writer.println("That is not a valid movie to return.");
        }
    }

    public void login() throws IOException {
        if(!loggedIn) {
            writer.print("You will need to login to do that.\nLibrary Number: ");
            String id = reader.readLine();
            writer.print("Password: ");
            String password = reader.readLine();
            if(userList.getUser(id).login(id, password)) {
                loggedIn = true;
                writer.println("Login successful");
            }
            else {
                writer.println("Login unsuccessful");
            }
        }
    }

    public void displayDetails() throws IOException {
        for (User u:userList.getUserList()) {
            if(u.isLoggedIn()) {
                writer.println(u.getDetails());
            }
        }

    }

    public boolean isLoggedIn() {
        return loggedIn;
    }
}
