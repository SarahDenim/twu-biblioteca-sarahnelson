package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class UserList {
    private List<User> userList = new ArrayList<User>();

    public void addUser(User user) {
        userList.add(user);
    }

    public User getUser(String username) {
        for (User u:userList) {
            if (u.getUsername().equals(username));
            return u;
        }
        return null;
    }

    public void setUpUserList() {
        User Sarah = new User("sarahn", "password");
        User Bob = new User("bobb", "password");

        addUser(Sarah);
        addUser(Bob);
    }
}
