package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class AdminLoginController {

    @FXML
    private Label messageLabel;

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField usernameField;

    @FXML
    void forgotPassLink(ActionEvent event) {
        // Handle forgot password functionality if needed
    }

    @FXML
    void loginButton(ActionEvent event) {

    }

    @FXML
    void returnLink(ActionEvent event) {
        try {
            loadClientLoginPage();
        } catch (IOException e) {
            e.printStackTrace();  // Print stack trace for debugging
        }
    }

    private void loadClientLoginPage() throws IOException {
        // Load the client login page and display it
        FXMLLoader loader = new FXMLLoader(getClass().getResource("login.fxml")); // Make sure this path matches your actual FXML file location
        Parent root = loader.load();
        // Get the current stage and set the new scene
        Stage stage = (Stage) usernameField.getScene().getWindow(); // Assuming the username field is on the same stage
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Client Login - BusBuddy");
        stage.show();
    }
}
