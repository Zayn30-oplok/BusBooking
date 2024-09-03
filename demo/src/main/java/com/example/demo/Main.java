package com.example.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    private Stage stage;

    public void start(Stage stage) throws IOException {
        this.stage = stage;
        this.LoginPage();
    }

    private void LoginPage() throws IOException {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("login.fxml"));
        Parent root = loader.load();
        this.stage.setTitle("Login");
        this.stage.setResizable(false);
        this.stage.setIconified(true);
        Scene scene = new Scene(root);
        this.stage.setScene(scene);
        this.stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
