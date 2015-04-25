package com.twu.biblioteca;

/**
 * Created by sarahnelson on 24/04/2015.
 */
public class User {
    private String id;
    private String password;
    private boolean isLoggedIn = false;
    private String email;
    private String phoneNumber;

    public User(String id, String password) {
        this.id = id;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public String getUserPassword() { return password; }

    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    public boolean login(String idNumber, String pass) {
        if ((id.equals(idNumber)) && (password.equals(pass))) {
            isLoggedIn = true;
            return true;
        }
        else {
            return false;
        }
    }

    public void setEmail(String e) {
        email = e;
    }

    public void setPhoneNumber(String p) {
        phoneNumber = p;
    }

    public String getDetails() {
        return id + " " + email + " " + phoneNumber;
    }
}
