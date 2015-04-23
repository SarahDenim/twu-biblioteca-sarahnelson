package com.twu.biblioteca;

import java.io.*;

public class BibliotecaApp {

    private InputStream in;

    Options menuOptions = new Options();

    public static void main(String[] args) throws IOException {
        BibliotecaApp app = new BibliotecaApp();
        app.start();
    }

    public BibliotecaApp(InputStream in) {
        this.in = in;
    }

    public BibliotecaApp() {
        this.in = System.in;
    }

    public void start () throws IOException {
        menuOptions.setUpBookList();
        menuOptions.welcomeMessage();
        menuOptions.mainMenu();

        while(true) {
            System.out.println("\nWhat would you like to do?");
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String input = br.readLine();

            char charInput = convertInputToChar(input);
            if(charInput == 'q') return;
            runCommand(charInput);
        }
    }

    public char convertInputToChar(String input) {
        return input.charAt(0);
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

    public void runCommand(char command) throws IOException {
        switch (command) {
            case 'm':
                menuOptions.mainMenu();
                break;
            case 1:
                menuOptions.listBooks();
                break;
            case 2:
                System.out.println("Which book do you wish to check out?");
                BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
                String input1 = br1.readLine();
                menuOptions.checkoutBook(input1);
                break;
            case 3:
                System.out.println("Which book do you wish to return?");
                BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
                String input2 = br2.readLine();
                menuOptions.returnBook(input2);
                break;
            default: System.err.println("Select a valid option!");
        }
    }
}