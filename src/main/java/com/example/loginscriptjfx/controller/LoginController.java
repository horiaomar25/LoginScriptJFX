package com.example.loginscriptjfx.controller;

import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import com.example.loginscriptjfx.model.User;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class LoginController {
    @FXML
    private TextField userNameInput;

    // PasswordField - hides password
    @FXML
    private PasswordField passwordInput;

    // Array of users
     ArrayList<User> users = new ArrayList<User>();

     // built in method to set up data after fxml UI is loaded. Will create a list of username and password after log-in-view is loaded
     public void initialize() {
         users.add(new User("JohnDoe", "Poodles123"));
         users.add(new User("JaneDoe", "Oranges234"));
         users.add(new User("JackSmith", "Pizza123"));
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

    public void onHandleLogin() throws IOException {
        String inputUserName = userNameInput.getText().trim();
        String inputPassword = passwordInput.getText().trim();

        // Error display if username and password is empty.
        if(inputUserName.isEmpty() || inputPassword.isEmpty()) {
            showErrorAlert("Both username and password must be entered");
            return;
        }

        boolean loggedIn = false;

        if (validateLogin(inputUserName, inputPassword)) {
            loggedIn = true;
           loadLoggedInPage();
        } else {
            displayFailedLoginMessage();
        }
    }

    // Loading loggedin page
    private void loadLoggedInPage() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/loginscriptjfx/loggedin.fxml"));
        Scene scene = new Scene(loader.load(), 400, 400);

        // Create new scene to the loggedin view
        // Stage is a subclass of Window object so can cast back to Stage object to display new scene(loggedin.fxml)
        Stage stage = (Stage) userNameInput.getScene().getWindow();

        stage.setScene(scene);
        stage.setTitle("Logged In");
        stage.show();
    }

    // Error for incorrect user login
    private void displayFailedLoginMessage () {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Login Failed");
        alert.setHeaderText("Incorrect Username or Password");
        alert.setContentText("The username or password is incorrect.");
        alert.showAndWait();
    }

    // Error message when user click login with empty inputs
    private void showErrorAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Login Failed");
        alert.setHeaderText("Required");
        alert.setContentText(message);
        alert.showAndWait();
    }
}