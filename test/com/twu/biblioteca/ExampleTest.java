package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ExampleTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    //private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    @Test
    public void test() {
        assertEquals(1, 1);
    }

    @Before
    public void setUpApp() throws IOException {
        ByteArrayInputStream inContent = new ByteArrayInputStream("1".getBytes());
        System.setIn(inContent);
    }

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        //System.setErr(new PrintStream(errContent));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
        //System.setErr(null);
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
    public void checkInputM() throws Exception {
        ByteArrayInputStream inContentM = new ByteArrayInputStream("m".getBytes());
        System.setIn(inContentM);
        assertEquals('m', new BibliotecaApp().checkInput());
    }

    @Test
    public void checkInputQ() throws Exception {
        ByteArrayInputStream inContentM = new ByteArrayInputStream("q".getBytes());
        System.setIn(inContentM);
        assertEquals('q', new BibliotecaApp().checkInput());
    }

    @Test
    public void checkInput1() throws Exception {
        ByteArrayInputStream inContent1 = new ByteArrayInputStream("1".getBytes());
        System.setIn(inContent1);
        assertEquals(1, new BibliotecaApp().checkInput());
    }
}
