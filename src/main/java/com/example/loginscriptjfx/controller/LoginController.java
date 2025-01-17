package com.example.loginscriptjfx.controller;

import com.example.loginscriptjfx.model.UserLogic;
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

    private UserLogic logic = new UserLogic();



    public void onHandleLogin() throws IOException {
        String inputUserName = userNameInput.getText().trim();
        String inputPassword = passwordInput.getText().trim();

        // Error display if username and password is empty.
        if(inputUserName.isEmpty() || inputPassword.isEmpty()) {
            showErrorAlert("Both username and password must be entered");
            return;
        }

        boolean loggedIn = false;

        if (logic.validateLogin(inputUserName, inputPassword)) {
            loggedIn = true;
            loadLoggedInPage();
        } else {
            displayFailedLoginMessage();
        }
    }




    // Loading loggedin page
  public void loadLoggedInPage() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/loginscriptjfx/loggedin.fxml"));
        Scene scene = new Scene(loader.load(), 400, 400);

        // Create new scene to the loggedin view
        // Stage is a subclass of Window object so can cast back to Stage object to display new scene(loggedin.fxml)
        Stage stage = (Stage) userNameInput.getScene().getWindow();

        // As the same in the Hello Application - must linked to css file so the new scene is associated with the styling.
        scene.getStylesheets().add(getClass().getResource("/com/example/loginscriptjfx/application.css").toExternalForm());

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