package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class UserList {
    private List<User> userList = new ArrayList<User>();

    public void addUser(User user) {
        userList.add(user);
    }

    public User getUser(String id) {
        for (User u:userList) {
            if (u.getId().equals(id)) {
                return u;
            }
        }
        return null;
    }

    public void setUpUserList() {
        User Sarah = new User("111-2345", "password");
        User Bob = new User("999-2144", "password");

        addUser(Sarah);
        Sarah.setEmail("sarahnelson@gmail.com");
        Sarah.setPhoneNumber("0712345678");
        addUser(Bob);
        Bob.setEmail("bobdunne@gmail.com");
        Bob.setPhoneNumber("0787654321");
    }

    public List<User> getUserList() {
        return userList;
    }
}
