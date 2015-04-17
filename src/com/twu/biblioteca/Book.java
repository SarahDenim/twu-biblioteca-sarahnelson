package com.twu.biblioteca;

/**
 * Created by sarahnelson on 17/04/2015.
 */
public class Book {

    private String name;
    private String author;
    private int yearPublished;
    private boolean checkedIn = true;

    public Book(String name, String author, int yearPublished) {
        this.name = name;
        this.author = author;
        this.yearPublished = yearPublished;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public void checkIn() {
        checkedIn = true;
    }

    public void checkOut() {
        checkedIn = false;
    }

    public boolean isCheckedIn() {
        return checkedIn;
    }
}