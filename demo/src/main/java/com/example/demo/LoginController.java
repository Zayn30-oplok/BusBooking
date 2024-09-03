package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {

    @FXML
    private AnchorPane pane;

    @FXML
    private Label clientInvalidLabel;

    @FXML
    private PasswordField passwordField;

    @FXML
    private RadioButton radioButton;

    @FXML
    private TextField usernameField;

    @FXML
    void forgotPassLink(ActionEvent event) {
        // Implement forgot password functionality if needed
    }

    @FXML
    void loginAsAdminButton(ActionEvent event) {
        try {
            loadAdminLoginPage();  // Load the admin login page correctly
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void loginButton(ActionEvent event) {
        try {
            clientAttemptLogin();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void initialize() {
        // Handle "Enter" key press to trigger client login
        passwordField.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                try {
                    clientAttemptLogin();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        radioButton.setOnAction(event -> handleRadioButtonClick());
    }

    private void handleRadioButtonClick() {
        // Preserve the current values of username and password fields
        String currentUsername = usernameField.getText();
        String currentPassword = passwordField.getText();

        // Example logic: Show/hide the invalid label if radio button is selected
        if (radioButton.isSelected()) {
            clientInvalidLabel.setVisible(false); // Hide any error messages when radio button is clicked
        } else {
            clientInvalidLabel.setVisible(true); // Show the error message label if the button isn't selected
        }

        // Set the text back to the username and password fields to ensure they are preserved
        usernameField.setText(currentUsername);
        passwordField.setText(currentPassword);

        // Additional actions can be implemented here if needed.
        // For instance, you could switch to another mode or enable/disable other buttons or fields.
    }

    private void clientAttemptLogin() throws IOException {
        String username = "filemon";
        String password = "123";
        String enteredUsername = usernameField.getText();
        String enteredPassword = passwordField.getText();

        // Check if fields are empty
        if (enteredUsername.isEmpty() || enteredPassword.isEmpty()) {
            clientInvalidLabel.setText("Please enter username and password!");
            clientInvalidLabel.setVisible(true);
            return;
        }

        if (username.equals(enteredUsername) && password.equals(enteredPassword)) {
            closeLoginPage();
            openClientPage();
        } else {
            clientInvalidLabel.setText("Invalid username or password!");
            clientInvalidLabel.setVisible(true);
        }
    }

    private void loadAdminLoginPage() throws IOException {
        // Correctly load the admin login page into the AnchorPane
        Parent view = FXMLLoader.load(getClass().getResource("admin-login.fxml"));
        pane.getChildren().clear();  // Clear current content
        pane.getChildren().add(view);  // Add new content
        AnchorPane.setTopAnchor(view, 0.0);
        AnchorPane.setRightAnchor(view, 0.0);
        AnchorPane.setBottomAnchor(view, 0.0);
        AnchorPane.setLeftAnchor(view, 0.0);
    }

    private void closeLoginPage() {
        Stage stage = (Stage) usernameField.getScene().getWindow();
        stage.close();
    }

    private void openClientPage() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("client-page.fxml"));
        Parent root = loader.load();
        Stage stage = new Stage();
        stage.setTitle("BusBuddy");
        stage.setResizable(false);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
