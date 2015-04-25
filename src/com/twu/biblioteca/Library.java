package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> bookList = new ArrayList<Book>();
    private List<Movie> movieList = new ArrayList<Movie>();

    public Book getBook(String name) {
        for (Book b:bookList) {
            if (b.getName().equals(name)) {
                return b;
            }
        }
        return null;
    }

    public void addBook(Book book) {
        bookList.add(book);
    }

    public void addMovie(Movie movie) {
        movieList.add(movie);
    }

    public void setUpBookList() {
        Book Gatsby = new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925);
        Book Rings = new Book("The Lord of the Rings", "J.R.R. Tolkien", 1954);

        addBook(Gatsby);
        addBook(Rings);
    }

    public void setUpMovieList() {
        Movie Budapest = new Movie("The Grand Budapest Hotel", 2014, "Wes Anderson", 8);
        Movie Nemo = new Movie("Finding Nemo", 2003, "Andrew Stanton", 8);

        addMovie(Budapest);
        addMovie(Nemo);
    }

    public List<Book> getCheckedInBooks() {
        List<Book> checkedInBooks = new ArrayList<Book>();
        for(Book b:bookList) {
            if(b.isCheckedIn()) {
                checkedInBooks.add(b);
            }
        }
        return checkedInBooks;
    }

    public List<Movie> getCheckedInMovies() {
        List<Movie> checkedInMovies = new ArrayList<Movie>();
        for(Movie m:movieList) {
            if(m.isCheckedIn()) {
                checkedInMovies.add(m);
            }
        }
        return checkedInMovies;
    }

    public List<Book> getCheckedOutBooks() {
        List<Book> checkedOutBooks = new ArrayList<Book>();
        for(Book b:bookList) {
            if(!b.isCheckedIn()) {
                checkedOutBooks.add(b);
            }
        }
        return checkedOutBooks;
    }

    public List<Movie> getCheckedOutMovies() {
        List<Movie> checkedOutMovies = new ArrayList<Movie>();
        for(Movie m:movieList) {
            if(!m.isCheckedIn()) {
                checkedOutMovies.add(m);
            }
        }
        return checkedOutMovies;
    }
}
