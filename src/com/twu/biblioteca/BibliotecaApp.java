package com.twu.biblioteca;

import java.io.*;

public class BibliotecaApp {

    private BufferedReader reader;
    private PrintStream writer;
    private Options options;

    public static void main(String[] args) throws IOException {
        BibliotecaApp app = new BibliotecaApp(System.in, System.out);
        app.start();
    }

    public BibliotecaApp(InputStream in, OutputStream out) {
        reader = new BufferedReader(new InputStreamReader(in));
        writer = new PrintStream(out);
        options = new Options(in, out);
    }

    public void start () throws IOException {
        welcomeMessage();
        mainMenu();

        while(true) {
            writer.println("\nWhat would you like to do?");

            String input = reader.readLine();
            if(input.length() > 1) {
                writer.println("Select a valid option!");
                continue;
            }
            char charInput = input.charAt(0);
            if(charInput == 'q') return;
            runCommand(charInput);
        }
    }

    public void welcomeMessage() throws IOException {
        writer.println("Welcome to Biblioteca! We're ready to rumble!");
    }

    public void mainMenu() throws IOException {
        writer.println("Main menu: \n1. List Books \n2. Checkout book \n" +
                "3. Return book \n\nCommands (use at any time) \nm: show main menu " +
                "\nq: quit");
    }

    public void runCommand(char command) throws IOException {
        switch (command) {
            case 'm':
                mainMenu();
                break;
            case '1':
                options.listBooks();
                break;
            case '2':
                options.checkoutBook();
                break;
            case '3':
                options.returnBook();
                break;
            case '4':
                options.listMovies();
                break;
            default:
                writer.println("Select a valid option!");
                break;
        }
    }
}