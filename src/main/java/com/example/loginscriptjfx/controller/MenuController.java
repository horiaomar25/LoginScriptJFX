package com.example.loginscriptjfx.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuController {
    @FXML
    Button signUpBtn;

    @FXML
    Button signInBtn;

    public void onLoginPage() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/loginscriptjfx/log-in-view.fxml"));
        Scene scene = new Scene(loader.load(), 1024, 768);
        Stage stage = (Stage) signInBtn.getScene().getWindow();
        scene.getStylesheets().add(getClass().getResource("/com/example/loginscriptjfx/application.css").toExternalForm());

        stage.setScene(scene);
        stage.setTitle("Login");
        stage.show();

    }

    public void onRegisterPage() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/loginscriptjfx/register-view.fxml"));

        Scene scene = new Scene(loader.load(), 1024, 768);
        Stage stage = (Stage) signInBtn.getScene().getWindow();
        scene.getStylesheets().add(getClass().getResource("/com/example/loginscriptjfx/application.css").toExternalForm());

        stage.setScene(scene);
        stage.setTitle("Register");
        stage.show();
    }

}
