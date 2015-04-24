package com.twu.biblioteca;

import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertEquals;

public class BibliotecaAppTest {

    @Test
    public void welcomeMessageTest() throws Exception {
        InputStream testInput = new ByteArrayInputStream("".getBytes());
        OutputStream testOutput = new ByteArrayOutputStream();

        BibliotecaApp app = new BibliotecaApp(testInput,testOutput);
        app.welcomeMessage();
        assertEquals("Welcome to Biblioteca! We're ready to rumble!\n", testOutput.toString());
    }

    @Test
    public void mainMenuTest() throws Exception {
        InputStream testInput = new ByteArrayInputStream("".getBytes());
        OutputStream testOutput = new ByteArrayOutputStream();

        BibliotecaApp app = new BibliotecaApp(testInput,testOutput);
        app.mainMenu();
        assertEquals("Main menu: \n1. List Books \n2. Checkout book \n" +
                "3. Return book \n\nCommands (use at any time) \nm: show main menu " +
                "\nq: quit\n", testOutput.toString());
    }

    @Test
    public void validMenuOptionTest() throws Exception {
        InputStream testInput = new ByteArrayInputStream("".getBytes());
        OutputStream testOutput = new ByteArrayOutputStream();

        BibliotecaApp app = new BibliotecaApp(testInput,testOutput);
        app.runCommand('m');
        assertEquals("Main menu: \n1. List Books \n2. Checkout book \n" +
                "3. Return book \n\nCommands (use at any time) \nm: show main menu " +
                "\nq: quit\n", testOutput.toString());
    }

    @Test
    public void invalidMenuOptionTest() throws Exception {
        InputStream testInput = new ByteArrayInputStream("".getBytes());
        ByteArrayOutputStream testOutput = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOutput));

        BibliotecaApp app = new BibliotecaApp(testInput, testOutput);

        app.runCommand('P');

        assertEquals("Select a valid option!\n", testOutput.toString());
    }

    @Test
    public void listBooksTest() throws IOException {
        InputStream testInput = new ByteArrayInputStream("".getBytes());
        OutputStream testOutput = new ByteArrayOutputStream();

        BibliotecaApp app = new BibliotecaApp(testInput, testOutput);
        app.runCommand('1');

        assertEquals("The Great Gatsby by F. Scott Fitzgerald, 1925\n" +
                "The Lord of the Rings by J.R.R. Tolkien, 1954\n", testOutput.toString());
    }

    @Test
    public void checkOutAvailableBookTest() throws IOException {
        InputStream testInput = new ByteArrayInputStream("The Great Gatsby\n".getBytes());
        OutputStream testOutput = new ByteArrayOutputStream();

        Options options = new Options(testInput, testOutput);
        options.checkoutBook();
        assertEquals("Which book do you wish to check out?\nThank you! Enjoy the book.\n", testOutput.toString());
    }

    @Test
    public void unsuccessfullyCheckOutUnavailableBookTest() throws IOException {
        InputStream testInput = new ByteArrayInputStream("The Flying Cats".getBytes());
        OutputStream testOutput = new ByteArrayOutputStream();

        Options options = new Options(testInput, testOutput);
        options.checkoutBook();
        assertEquals("Which book do you wish to check out?\nThat book is not available.\n", testOutput.toString());
    }

    @Test
    public void SuccessfullyReturnAvailableBookTest() throws IOException {
        InputStream testInput = new ByteArrayInputStream("The Great Gatsby\nThe Great Gatsby".getBytes());
        OutputStream testOutput = new ByteArrayOutputStream();

        Options options = new Options(testInput, testOutput);
        options.checkoutBook();
        options.returnBook();
        assertEquals("Which book do you wish to check out?\nThank you! Enjoy the book.\nWhich book do you wish " +
                "to return?\nThank you for returning the book.\n", testOutput.toString());
    }

    @Test
    public void UnsuccessfullyReturnUnavailableBookTest() throws IOException {
        InputStream testInput = new ByteArrayInputStream("The Great Gatsby".getBytes());
        OutputStream testOutput = new ByteArrayOutputStream();
        Options options = new Options(testInput, testOutput);
        options.returnBook();
        assertEquals("Which book do you wish to return?\nThat is not a valid book to return.\n", testOutput.toString());
    }
}
