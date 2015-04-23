package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertEquals;

public class BibliotecaAppTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    /*@Before
    public void setUpApp() throws IOException {
        ByteArrayInputStream inContent = new ByteArrayInputStream("1".getBytes());
        System.setIn(inContent);
    }*/

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        //System.setErr(new PrintStream(errContent));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }

    @Test
    public void welcomeMessageTest() throws Exception {
        new BibliotecaApp().welcomeMessage();
        assertEquals("Welcome to Biblioteca! We're ready to rumble!\n", outContent.toString());
    }

    @Test
    public void mainMenuTest() throws Exception {
        new BibliotecaApp().mainMenu();
        assertEquals("Main menu: \n1. List Books \n2. Checkout book \n" +
                "3. Return book \n\nCommands (use at any time) \nm: show main menu " +
                "\nq: quit\n", outContent.toString());
    }

    @Test
    public void invalidMenuOptionTest() throws Exception {
        ByteArrayOutputStream errContent = new ByteArrayOutputStream();

        InputStream testInput = new ByteArrayInputStream("P\n".getBytes());

        BibliotecaApp app = new BibliotecaApp(testInput);

        app.start();
        System.setErr(new PrintStream(errContent));
        //assertEquals(0, new BibliotecaApp().checkInput("P"));

        assertEquals("Select a valid option!\n", errContent.toString());
    }

    @Test
    public void listBooksTest() throws IOException {
        Library library = new Library();
        library.setUpBookList();
        library.listBooks();
        assertEquals("The Great Gatsby by F. Scott Fitzgerald, 1925\n" +
                     "The Lord of the Rings by J.R.R. Tolkien, 1954\n", outContent.toString());
    }

    /*@Test
    public void checkOutAvailableBookTest() {
        Library library = new Library();
        library.setUpBookList();
        library.checkoutBook("The Great Gatsby");
        assertEquals("Thank you! Enjoy the book.\n", outContent.toString());
    }

    @Test
    public void unsuccessfullyCheckOutUnavailableBookTest() {
        Library library = new Library();
        library.setUpBookList();
        library.checkoutBook("The Flying Cats");
        assertEquals("That book is not available.\n", outContent.toString());
    }

    @Test
    public void SuccessfullyReturnAvailableBookTest() {
        Library library = new Library();
        library.setUpBookList();
        library.checkoutBook("The Great Gatsby");
        library.returnBook("The Great Gatsby");
        assertEquals("Thank you! Enjoy the book.\nThank you for returning the book.\n", outContent.toString());
    }

    @Test
    public void UnsuccessfullyReturnUnavailableBookTest() {
        Library library = new Library();
        library.setUpBookList();
        library.returnBook("The Great Gatsby");
        assertEquals("That is not a valid book to return.\n", outContent.toString());
    }*/





    /*@Test
    public void checkInputReturnsMGivenM() throws Exception {
        assertEquals('m', new BibliotecaApp().checkInput("m"));
    }

    @Test
    public void checkInputReturns1Given1() throws Exception {
        assertEquals(1, new BibliotecaApp().checkInput("1"));
    }

    @Test
    public void checkInputReturns2Given2() throws Exception {
        assertEquals(2, new BibliotecaApp().checkInput("2"));
    }

    @Test
    public void checkInputReturns3Given3() throws Exception {
        assertEquals(3, new BibliotecaApp().checkInput("3"));
    }*/
}
