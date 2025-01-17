package com.example.loginscriptjfx.model;

import java.util.ArrayList;

public class UserLogic {
    // Array of users
    ArrayList<User> users = new ArrayList<User>();


    // built in method to set up data after fxml UI is loaded. Will create a list of username and password after log-in-view is loaded
    public void initialize() {
        users.add(new User("JohnDoe", "Poodles123"));
        users.add(new User("JaneDoe", "Oranges234"));
        users.add(new User("JackSmith", "Pizza123"));
    }

    public void addUser(User user) {
        users.add(user);
    }

    // Check if username already exists when user registers
    public boolean checkForExistingUser(String username) {
        for(User user : users) {
            if(user.getUsername().equals(username) ) {
                return true;
            }
        }
        return false;
    }

    public boolean validateLogin(String inputUserName, String inputPassword) {
        // loop over user arraylist
        for(User user : users) {
            if(user.getUsername().equals(inputUserName) && user.getPassword().equals(inputPassword)) {
                return true;
            }
        }
        return false;
    }
}
