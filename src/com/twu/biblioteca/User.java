package com.twu.biblioteca;

/**
 * Created by sarahnelson on 24/04/2015.
 */
public class User {
    private String username;
    private String password;
    private boolean isLoggedIn = false;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getUserPassword() { return password; }

    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    public void login() {
        isLoggedIn = true;
    }
}
