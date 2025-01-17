package com.example.loginscriptjfx;

import com.example.loginscriptjfx.controller.LoginController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/example/loginscriptjfx/menu-view.fxml"));

        Scene scene = new Scene(fxmlLoader.load(), 1024, 768);

        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

        stage.setTitle("Login");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}