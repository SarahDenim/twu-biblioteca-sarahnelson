package com.twu.biblioteca;

import java.io.*;

public class BibliotecaApp {

    private InputStream in;
    private OutputStream out;
    private BufferedReader reader;
    private PrintWriter writer;

    private Library library;

    public static void main(String[] args) throws IOException {
        BibliotecaApp app = new BibliotecaApp();
        app.start();
    }

    /*public BibliotecaApp() {
        this.in = System.in;
        this.out = System.out;
    }*/

    public BibliotecaApp() {
        //this.in = in;
        //this.out = out;
        reader = new BufferedReader(new InputStreamReader(System.in));
        //writer = new PrintWriter(out);
        library = new Library();
    }

    public void start () throws IOException {
        library.setUpBookList();
        welcomeMessage();
        mainMenu();

        while(true) {
            System.out.println("\nWhat would you like to do?");
            //Scanner sc = new Scanner(System.in);
            //String input = sc.nextLine();
            //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            //String input = reader.readLine();

            char charInput = (char)reader.read();
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
            case '1':
                library.listBooks();
                break;
            case 2:
                library.checkoutBook();
                break;
            case 3:
                library.returnBook();
                break;
            default:
                System.out.println("Select a valid option!");
                //writer.println("Select a valid option!");
                break;
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