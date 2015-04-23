package com.twu.biblioteca;

import java.io.*;
import java.util.Scanner;

public class BibliotecaApp {

    final private InputStream in;
    final private OutputStream out;

    Library library = new Library();

    public static void main(String[] args) throws IOException {
        BibliotecaApp app = new BibliotecaApp();
        app.start();
    }

    public BibliotecaApp(InputStream in, OutputStream out) {
        this.in = in;
        this.out = out;
    }

    public BibliotecaApp() {
        in = System.in;
        out = System.out;
    }

    public void start () throws IOException {
        library.setUpBookList();
        welcomeMessage();
        mainMenu();

        while(true) {
            System.out.println("\nWhat would you like to do?");
            Scanner sc = new Scanner(in);
            String input = sc.nextLine();
            //BufferedReader br = new BufferedReader(new InputStreamReader(systemIn));
            //String input = br.readLine();

            char charInput = convertInputToChar(input);
            if(charInput == 'q') return;
            runCommand(charInput);
        }
    }

    public void welcomeMessage() throws IOException {
        System.out.println("Welcome to Biblioteca! We're ready to rumble!");
    }

    public void mainMenu() throws IOException {
        System.out.println("Main menu: \n1. List Books \n2. Checkout book \n" +
                "3. Return book \n\nCommands (use at any time) \nm: show main menu " +
                "\nq: quit");
    }

    public char convertInputToChar(String input) {
        return input.charAt(0);
    }

    public void runCommand(char command) throws IOException {
        switch (command) {
            case 'm':
                mainMenu();
                break;
            case 1:
                library.listBooks();
                break;
            case 2:
                library.checkoutBook();
                break;
            case 3:
                library.returnBook();
                break;
            default: System.err.println("Select a valid option!");
        }
    }

    /*public char checkInput(String input) throws IOException {

        if (input.equals("m")) {
            return 'm';
        }
        else {
            int inputInt;

            try {
                //check if input is an integer
                inputInt = Integer.parseInt(input);
                if (inputInt == 1) {
                    return 1;
                }
                else if (inputInt == 2) {
                    return 2;
                }
                else if (inputInt == 3) {
                    return 3;
                }
            } catch (NumberFormatException nfe) {
                System.err.println("Select a valid option!");
                return 0;
            }
        }
        System.err.println("Select a valid option!");
        return 0;
    }*/


}