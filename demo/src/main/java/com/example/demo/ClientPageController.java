package com.example.demo;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class ClientPageController {

    @FXML
    private ChoiceBox<String> departureChoice;

    @FXML
    private DatePicker departureDate;

    @FXML
    private ChoiceBox<String> destinationChoice;

    @FXML
    private TextField oneWayField;

    @FXML
    private Spinner<Integer> passengerCount;

    @FXML
    private DatePicker returnDate;

    @FXML
    private Text returnLabel;

    @FXML
    private RadioButton roundTrip;

    @FXML
    private RadioButton oneWay;

    @FXML
    void initialize() {
        // Initialize passenger count spinner
        passengerCount.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 40, 0)); // Min 1, Max 10, Initial value 1

        // Set initial state
        oneWay.setSelected(true);
        returnDate.setDisable(true);
        oneWayField.setEditable(false);
        passengerCount.setEditable(true);
        returnDate.setVisible(false);
        returnLabel.setVisible(false);

        // Set up listeners for radio buttons
        oneWay.setOnAction(event -> handleOneWaySelection());
        roundTrip.setOnAction(event -> handleRoundTripSelection());

        // Set initial Origin Cities
        departureChoice.setItems(FXCollections.observableArrayList("Cagayan De Oro City", "Zamboanga City", "Davao City", "General Santos City", "Surigao", "Butuan"));
        departureChoice.setValue("Select Departure City");

        // Set initial Destination Cities
        destinationChoice.setItems(FXCollections.observableArrayList("Cagayan De Oro City", "Zamboanga City", "Davao City", "General Santos City", "Surigao", "Butuan"));
        destinationChoice.setValue("Select Destination City");
    }

    private void handleOneWaySelection() {
        if (oneWay.isSelected()) {
            oneWayField.setVisible(true);  // Show the one-way specific field
            returnDate.setDisable(true);   // Disable return date picker
            returnDate.setVisible(false);  // Hide the return date picker
            returnLabel.setVisible(false); // Hide the return label
            roundTrip.setSelected(false);  // Unselect round trip button
        }
    }

    private void handleRoundTripSelection() {
        if (roundTrip.isSelected()) {
            oneWayField.setVisible(false); // Hide the one-way specific field
            returnDate.setDisable(false);  // Enable the return date picker
            returnDate.setVisible(true);   // Show the return date picker
            returnLabel.setText("Return Date");
            returnLabel.setVisible(true);  // Show the return label
            oneWay.setSelected(false);     // Unselect one-way button
        }
    }


    @FXML
    void findButtonClick(ActionEvent event) {
        if (validateInputs()) {
            if (departureChoice.getValue().equals(destinationChoice.getValue())) {
                // Show confirmation alert if departure and destination are the same
                Alert confirmationAlert = new Alert(Alert.AlertType.CONFIRMATION);
                confirmationAlert.setTitle("Same Departure and Destination");
                confirmationAlert.setHeaderText(null);
                confirmationAlert.setContentText("Departure and destination are the same. Are you sure you want to continue?");

                // Add Yes and No buttons
                ButtonType yesButton = new ButtonType("Yes", ButtonBar.ButtonData.YES);
                ButtonType noButton = new ButtonType("No", ButtonBar.ButtonData.NO);

                confirmationAlert.getButtonTypes().setAll(yesButton, noButton);

                // Show alert and wait for user's choice
                confirmationAlert.showAndWait().ifPresent(response -> {
                    if (response == yesButton) {
                        // User confirmed to continue, proceed with ticket finding
                        try {
                            findTickets();
                            closePage();// Method to load the next scene
                        } catch (IOException e) {
                            e.printStackTrace();
                            showAlert("Failed to load the next page.");
                        }
                    }
                    // If "No" is clicked, do nothing and return
                });
            } else {
                // Proceed normally if departure and destination are different
                try {
                    findTickets();// Method to load the next scene
                    closePage();
                } catch (IOException e) {
                    e.printStackTrace(); // Handle exception as needed, e.g., log or show alert
                    showAlert("Failed to load the next page.");
                }
            }
        } else {
            showAlert("Please fill in all required fields.");
        }
    }


    private boolean validateInputs() {
        // Example validation: check if departure and destination are selected
        return !departureChoice.getValue().equals("Select Departure City")
                && !destinationChoice.getValue().equals("Select Destination City")
                && departureDate.getValue() != null
                && (oneWay.isSelected() || (roundTrip.isSelected() && returnDate.getValue() != null));
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Validation Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }


    @FXML
    void logOutButton(ActionEvent event) throws IOException {
        closePage();
        backToLogin();

    }

    private void closePage() {
        Stage stage = (Stage) passengerCount.getScene().getWindow();
        stage.close();
    }

    private void backToLogin() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("login.fxml"));
        Parent root = loader.load();
        Stage stage = new Stage();
        stage.setTitle("Main");
        stage.setResizable(false);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    private void findTickets() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("find.fxml"));
        Parent root = loader.load();
        Stage stage = new Stage();
        stage.setTitle("Main");
        stage.setResizable(false);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }



}
