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
        options.mainMenu();

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

    public void runCommand(char command) throws IOException {
        switch (command) {
            case 'm':
                options.mainMenu();
                break;
            case '1':
                options.listBooks();
                break;
            case '2':
                options.login();
                options.checkoutBook();
                break;
            case '3':
                options.returnBook();
                break;
            case '4':
                options.listMovies();
                break;
            case '5':
                if(options.isLoggedIn()) { options.displayDetails(); }
                break;
            default:
                writer.println("Select a valid option!");
                break;
        }
    }
}