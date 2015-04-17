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
        ByteArrayInputStream inContentM = new ByteArrayInputStream("m".getBytes());
        System.setIn(inContentM);
        assertEquals('m', new BibliotecaApp().checkInput());
    }

    @Test
    public void checkInput1() throws Exception {
        ByteArrayInputStream inContent1 = new ByteArrayInputStream("1".getBytes());
        System.setIn(inContent1);
        assertEquals(1, new BibliotecaApp().checkInput());
    }

    @Test
    public void checkInput2() throws Exception {
        ByteArrayInputStream inContent2 = new ByteArrayInputStream("2".getBytes());
        System.setIn(inContent2);
        assertEquals(2, new BibliotecaApp().checkInput());
    }

    @Test
    public void checkInput3() throws Exception {
        ByteArrayInputStream inContent3 = new ByteArrayInputStream("3".getBytes());
        System.setIn(inContent3);
        assertEquals(3, new BibliotecaApp().checkInput());
    }
}
