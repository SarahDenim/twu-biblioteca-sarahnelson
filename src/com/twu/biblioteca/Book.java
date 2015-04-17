package com.twu.biblioteca;

/**
 * Created by sarahnelson on 17/04/2015.
 */
public class Book {

    private String name;
    private String author;
    private int year_published;
    private boolean checkedIn = true;

    public Book(String name, String author, int year_published) {
        this.name = name;
        this.author = author;
        this.year_published = year_published;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear_published() {
        return year_published;
    }

    public void setYear_published(int year_published) {
        this.year_published = year_published;
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