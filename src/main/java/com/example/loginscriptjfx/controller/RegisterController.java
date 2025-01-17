package com.example.loginscriptjfx.controller;

import com.example.loginscriptjfx.model.User;
import com.example.loginscriptjfx.model.UserLogic;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;

import java.io.IOException;
import java.util.ArrayList;


public class RegisterController {



    @FXML
    private TextField userNameCreation;

    @FXML
    PasswordField passwordCreation;

    private UserLogic logic = new UserLogic();


    public void onHandleRegisterNewUser(){
        String userName = userNameCreation.getText().trim();
        String password = passwordCreation.getText().trim();

        // Validate
        if(userName.isEmpty() || password.isEmpty()){
            showErrorAlert("Both username and password are required");
        }

        if(logic.checkForExistingUser(userName)){
            showErrorAlert("Username already exists. Try another username.");
        } else{
            User user = new User(userName, password);
            logic.addUser(user);
            showConfirmationAlert();
        }

    }

    public void showConfirmationAlert(){
        Alert confirmNewUserRegistered = new Alert(Alert.AlertType.CONFIRMATION);
        confirmNewUserRegistered.setTitle("Confirmation");
        confirmNewUserRegistered.setHeaderText("You have successfully registered a new user");
        confirmNewUserRegistered.showAndWait();
    }

    // Error message when user click register with empty inputs
    private void showErrorAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Registration Failed");
        alert.setHeaderText("Required");
        alert.setContentText(message);
        alert.showAndWait();
    }
}
