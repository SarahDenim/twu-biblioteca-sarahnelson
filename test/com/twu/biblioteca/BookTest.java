package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.*;

import static org.junit.Assert.assertEquals;

public class BookTest {

    @Test
    public void getNameTest() {
        Book book = new Book("1984", "George Orwell", 1949);
        assertEquals("1984", book.getName());
    }

    @Test
    public void getAuthorTest() {
        Book book = new Book("1984", "George Orwell", 1949);
        assertEquals("George Orwell", book.getAuthor());
    }

    @Test
    public void getYearPublishedTest() {
        Book book = new Book("1984", "George Orwell", 1949);
        assertEquals(1949, book.getYearPublished());
    }

    @Test
    public void isCheckedInTest() {
        Book book = new Book("1984", "George Orwell", 1949);
        book.checkIn();
        assertEquals(true, book.isCheckedIn());
    }

    @Test
    public void isCheckedOutTest() {
        Book book = new Book("1984", "George Orwell", 1949);
        book.checkOut();
        assertEquals(false, book.isCheckedIn());
    }
}
