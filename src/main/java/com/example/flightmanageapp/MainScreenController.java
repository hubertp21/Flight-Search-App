package com.example.flightmanageapp;

import entitiesAndMappings.Flight;
import entitiesAndMappings.FlightMapping;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import utils.EntityManager;
import utils.FlightTableView;

import java.sql.Date;
import java.sql.SQLException;

public class MainScreenController {

    @FXML
    private AnchorPane flightsAnchorPane;

    @FXML
    private TableView<FlightTableView> flightsTableView;

    @FXML
    private TableColumn<FlightTableView, String> fromTableColumn;

    @FXML
    private TableColumn<FlightTableView, String> toTableColumn;

    @FXML
    private TableColumn<FlightTableView, Date> dateTableColumn;

    @FXML
    private TableColumn<FlightTableView, Integer> costTableColumn;

    @FXML
    private Button searchButton;

    @FXML
    private Button bookFlightButton;

    @FXML
    private Button exitButton;

    @FXML
    private TextField fromTextField;

    @FXML
    private TextField toTextField;

    @FXML
    private Label bookingMessageLabel;


    private ObservableList<FlightTableView> flightsOL = FXCollections.observableArrayList();

    public void searchButtonOnAction(ActionEvent event) throws SQLException {

        flightsTableView.getItems().clear();

        String from = fromTextField.getText();
        String to = toTextField.getText();

        EntityManager entityManager = new EntityManager();
        entityManager.setConnection();
        entityManager.setFlightMapping(new FlightMapping(new Flight(from, to)));

        flightsOL = entityManager.flightMapping.checkFlight(entityManager.getConnection());

        fromTableColumn.setCellValueFactory(new PropertyValueFactory<>("from"));
        toTableColumn.setCellValueFactory(new PropertyValueFactory<>("to"));
        dateTableColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        costTableColumn.setCellValueFactory(new PropertyValueFactory<>("cost"));

        flightsTableView.setItems(flightsOL);

        flightsAnchorPane.setVisible(true);
    }

    public void bookFlightButtonOnAction(ActionEvent event) {
        ObservableList<FlightTableView> selectedItems;
        selectedItems = flightsTableView.getSelectionModel().getSelectedItems();
        System.out.println(selectedItems);

        bookingMessageLabel.setText("Flight Successfully booked!");
    }

    public void exitButtonOnAction(ActionEvent event) {
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }
}
