package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
    public void shouldSuccessfullyCheckInAnAvailableBook() {
        Book book = new Book("1984", "George Orwell", 1949);
        book.checkIn();
        assertTrue(book.isCheckedIn());
    }

    @Test
    public void shouldSuccessfullyCheckOutAnAvailableBook() {
        Book book = new Book("1984", "George Orwell", 1949);
        book.checkOut();
        assertEquals(false, book.isCheckedIn());
    }

    /*@Test
    public void shouldUnsuccessfullyCheckOutAnUnavailableBook() {
        Book book = new Book("1984", "GeorgeOrwell", 1949);
        book.checkOut();
        assertEquals(false, book.isCheckedIn());
    }*/

}
