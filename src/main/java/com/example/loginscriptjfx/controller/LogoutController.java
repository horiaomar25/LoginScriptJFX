package com.example.loginscriptjfx.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import java.io.IOException;



public class LogoutController   {

    @FXML
    private Button logoutButton;

    @FXML
    public void onHandleLogout() throws IOException {
        // confirmation alert will be have ok and cancel button
        Alert confirmation = new Alert(Alert.AlertType.CONFIRMATION);
        confirmation.setTitle("Confim Logout");
        confirmation.setHeaderText("Are you sure you want to logout?");
        // showAndWait() - waiting for the user to perform a action. Returns the user choice of button clicked.
        if(confirmation.showAndWait().get() == ButtonType.OK){
            loadLoginScreen();
        }

    }

    private void loadLoginScreen() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/loginscriptjfx/log-in-view.fxml"));

        Scene scene = new Scene(loader.load(), 400, 400);

        // As the same in the Hello Application - must be linked to css file so the new scene is associated with the styling.
        scene.getStylesheets().add(getClass().getResource("/com/example/loginscriptjfx/application.css").toExternalForm());

        Stage stage = (Stage) logoutButton.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Login");
        stage.show();
    }
}
