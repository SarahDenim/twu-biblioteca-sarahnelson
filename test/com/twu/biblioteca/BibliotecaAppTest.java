package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertEquals;

public class BibliotecaAppTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUpApp() throws IOException {
        ByteArrayInputStream inContent = new ByteArrayInputStream("1".getBytes());
        System.setIn(inContent);
    }

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }

    @Test
    public void welcomeMessageTest() throws Exception {
        new Options().welcomeMessage();
        assertEquals("Welcome to Biblioteca! We're ready to rumble!\n", outContent.toString());
    }

    @Test
    public void mainMenuTest() throws Exception {
        new Options().mainMenu();
        assertEquals("Main menu: \n1. List Books \n2. Checkout book \n" +
                "3. Return book \n\nCommands (use at any time) \nm: show main menu " +
                "\nq: quit\n", outContent.toString());
    }

    @Test
    public void checkInputM() throws Exception {
        assertEquals('m', new BibliotecaApp().checkInput("m"));
    }

    @Test
    public void checkInput1() throws Exception {
        assertEquals(1, new BibliotecaApp().checkInput("1"));
    }

    @Test
    public void checkInput2() throws Exception {
        assertEquals(2, new BibliotecaApp().checkInput("2"));
    }

    @Test
    public void checkInput3() throws Exception {
        assertEquals(3, new BibliotecaApp().checkInput("3"));
    }

    @Test
    public void checkInvalidInput() throws Exception {
        assertEquals(0, new BibliotecaApp().checkInput("P"));
    }

    @Test
    public void listBooksTest() throws IOException {
        Options options = new Options();
        options.setUpBookList();
        options.listBooks();
        assertEquals("The Great Gatsby by F. Scott Fitzgerald, 1925\n" +
                     "The Lord of the Rings by J.R.R. Tolkien, 1954\n", outContent.toString());
    }

    @Test
    public void checkOutBookTest() {
        Options options = new Options();
        options.setUpBookList();
        options.checkoutBook("The Great Gatsby");
        assertEquals("Thank you! Enjoy the book.\n", outContent.toString());
    }

    @Test
    public void returnBookTest() {
        Options options = new Options();
        options.setUpBookList();
        options.checkoutBook("The Great Gatsby");
        options.returnBook("The Great Gatsby");
        assertEquals("Thank you! Enjoy the book.\nThank you for returning the book.\n", outContent.toString());
    }
}
