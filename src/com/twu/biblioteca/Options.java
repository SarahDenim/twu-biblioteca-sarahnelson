package com.twu.biblioteca;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Options {

    private BufferedReader reader;
    private PrintStream writer;
    //private Library library;
    private List<Book> bookList = new ArrayList<Book>();
    //private List<Movie> movieList = new ArrayList<Movie>();

    public Options(InputStream in, OutputStream out) {
        reader = new BufferedReader(new InputStreamReader(in));
        writer = new PrintStream(out);
        //library = new Library;
        setUpBookList();
    }

    public void setUpBookList() {
    Book Gatsby = new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925);
    Book Rings = new Book("The Lord of the Rings", "J.R.R. Tolkien", 1954);

    bookList.add(Gatsby);
    bookList.add(Rings);
    }

    public void listBooks() throws IOException {
        for (Book b:bookList) {
            if(b.isCheckedIn()){
                writer.print(b.getName() + " by ");
                writer.print(b.getAuthor() + ", ");
                writer.println(b.getYearPublished());
            }
        }
    }

    /*public void listMovies() {
        for (Movie m:movieList) {
            if(m.isCheckedIn()){
                System.out.print(m.getName() + " by ");
                System.out.print(m.getDirector() + ", ");
                System.out.print(m.getYear());
                System.out.println(m.getRating());
            }
        }
    }*/

    public void checkoutBook() throws IOException {
        writer.println("Which book do you wish to check out?");
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String book = reader.readLine();

        boolean success = false;
        for(Book b:bookList) {
            if (b.getName().equals(book) && (b.isCheckedIn())) {
                b.checkOut();
                writer.println("Thank you! Enjoy the book.");
                success = true;
            }
        }
        if (!success) {
            writer.println("That book is not available.");
        }
    }

    public void returnBook() throws IOException {
        writer.println("Which book do you wish to return?");
        String book = reader.readLine();

        boolean success = false;
        for(Book b:bookList) {
            if (b.getName().equals(book) && (!b.isCheckedIn())) {
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