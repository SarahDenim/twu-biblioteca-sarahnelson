package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BibliotecaApp {

    public static void main(String[] args) throws IOException {

        System.out.println("Welcome to Biblioteca! We're ready to rumble!");
        System.out.println("Main menu: \n1. List Books \n(use numbers to select menu items) \n\nCommands" +
                "\nm: show main menu\nl: list books \nco <book-name>: checkout book \nr <book-name>: return book" +
                " \nc: show commands");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("What would you like to do?");

        //check if input is a number (selecting menu item) or a command

        try{
            int i = Integer.parseInt(br.readLine());
            System.out.println(i);
        }catch(NumberFormatException nfe){
            System.err.println("Invalid Format!");
        }
        String s = br.readLine();
        System.out.println(s);

        //use switch statement to process command
    }
}
