package com.twu.biblioteca;

import java.io.*;

public class Options {

    private BufferedReader reader;
    private PrintStream writer;
    private Library library;

    public Options(InputStream in, OutputStream out) {
        reader = new BufferedReader(new InputStreamReader(in));
        writer = new PrintStream(out);
        library = new Library();
        library.setUpBookList();
        library.setUpMovieList();
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
}