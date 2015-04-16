package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BibliotecaApp {

    private List<Book> bookList = new ArrayList();

    public static void main(String[] args) throws IOException {

        System.out.println("Welcome to Biblioteca! We're ready to rumble!");
        System.out.println("Main menu: \n1. List Books \n(use numbers to select menu items) \n\nCommands" +
                "\nm: show main menu\nl: list books \nco <book-name>: checkout book \nr <book-name>: return book" +
                " \nc: show commands");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("What would you like to do?");

        //check if input is a number (selecting menu item) or a command

        String command = new String();
        int inputInt;
        String input;

        input = br.readLine();

        try{
            //check if input is an integer
            inputInt = Integer.parseInt(br.readLine());
            if (inputInt == 1) {
                System.out.println("listing books");
                //call list books method
            }
            else {
                System.out.println("Enter valid menu item number");
            }

        }catch(NumberFormatException nfe){
            command = input;
            //run command according to input

            //else error message
            //System.err.println("Invalid Format!");
        }

        //use switch statement to process command

    }
}
