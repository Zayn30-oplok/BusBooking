package com.example.demo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class FindController implements Initializable {

    @FXML
    private CheckBox bachelorCheck;

    @FXML
    private TableColumn<BusBook, String> busBrand;

    @FXML
    private TableColumn<BusBook, String> busCom;

    @FXML
    private TableColumn<BusBook, String> busNumber;

    @FXML
    private TableColumn<BusBook, String> date;

    @FXML
    private TableColumn<BusBook, String> departure;

    @FXML
    private TableColumn<BusBook, String> destination;

    @FXML
    private TableColumn<BusBook, String> estimated;

    @FXML
    private CheckBox pabamaCheck;

    @FXML
    private CheckBox ruralCheck;

    @FXML
    private TableColumn<BusBook, String> status;

    @FXML
    private TableColumn<BusBook, Integer> stops;

    @FXML
    private CheckBox superCheck;

    @FXML
    private TableView<BusBook> tableSchedules;

    @FXML
    private TableColumn<BusBook, Double> fareColumn;

    @FXML
    private TableColumn<BusBook, String> time;


    private ObservableList<BusBook> busBooks;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        busNumber.setCellValueFactory(new PropertyValueFactory<>("busNumber"));
        busCom.setCellValueFactory(new PropertyValueFactory<>("name"));
        busBrand.setCellValueFactory(new PropertyValueFactory<>("brand"));
        departure.setCellValueFactory(new PropertyValueFactory<>("departure"));
        destination.setCellValueFactory(new PropertyValueFactory<>("destination"));
        stops.setCellValueFactory(new PropertyValueFactory<>("stop"));
        date.setCellValueFactory(new PropertyValueFactory<>("date"));
        time.setCellValueFactory(new PropertyValueFactory<>("time"));
        estimated.setCellValueFactory(new PropertyValueFactory<>("eat"));
        status.setCellValueFactory(new PropertyValueFactory<>("stat"));
        fareColumn.setCellValueFactory(new PropertyValueFactory<>("fare"));

        // Set cell factory for the status column
        status.setCellFactory(column -> new TableCell<BusBook, String>() {
            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText(null);
                    setStyle("");
                } else {
                    setText(item);
                    if (item.equalsIgnoreCase("Fully Booked")) {
                        setTextFill(Color.RED); // Set text color to red
                        setStyle("-fx-background-color: #FFCCCC;"); // Optional: set cell background color
                    } else {
                        setTextFill(Color.BLACK); // Default text color
                        setStyle("-fx-background-color: #7ED348;");
                    }
                }
            }
        });

        busBooks = FXCollections.observableArrayList(
                new BusBook("1001", "Rural Transit Mindanao Inc.", "Yutong", "Cagayan De Oro City", "Davao City", 3, "9/10/2023", "12:00 am", "8:30 am", "10 Seats Remaining", 820.00),
                new BusBook("2134", "Pabama Tours", "King Long", "Cagayan De Oro City", "Wao", 3, "9/4/2024", "8:00 am", "11:30 am", "Fully Booked", 340.00)
        );

        tableSchedules.setItems(busBooks);
    }

    @FXML
    void reserveButton(ActionEvent event) {
        // Implementation for reserve button
    }

    @FXML
    void returnButton(ActionEvent event) {
        // Implementation for return button
    }
}
