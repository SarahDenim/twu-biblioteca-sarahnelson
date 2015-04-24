package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Library {

    private List<Book> bookList = new ArrayList<Book>();
    //private List<Movie> movieList = new ArrayList<Movie>();

    public void setUpBookList() {
    Book Gatsby = new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925);
    Book Rings = new Book("The Lord of the Rings", "J.R.R. Tolkien", 1954);

    bookList.add(Gatsby);
    bookList.add(Rings);
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
        System.out.println("Which book do you wish to check out?");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String book = br.readLine();

        boolean success = false;
        for(Book b:bookList) {
            if (b.getName().equals(book) && (b.isCheckedIn())) {
                b.checkOut();
                System.out.println("Thank you! Enjoy the book.");
                success = true;
            }
        }
        if (!success) {
            System.out.println("That book is not available.");
        }
    }

    public void returnBook() throws IOException {
        System.out.println("Which book do you wish to return?");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String book = br.readLine();

        boolean success = false;
        for(Book b:bookList) {
            if (b.getName().equals(book) && (!b.isCheckedIn())) {
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