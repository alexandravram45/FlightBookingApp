package org.loose.fis.sre.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import org.loose.fis.sre.exceptions.NoFlightsAvailable;
import org.loose.fis.sre.model.Flight;
import org.loose.fis.sre.services.FlightsService;

public class SeeInterestedFlightsController {
    @FXML
    private Text errorMessage;
    @FXML
    public TableView flightsTable;
    @FXML
    public TableColumn<Flight, String> fromColumn;
    @FXML
    public TableColumn<Flight, String> toColumn;
    @FXML
    public TableColumn<Flight, String> flightDateColumn;

    @FXML
    public TableColumn<Flight, Integer> priceColumn;
    @FXML
    public TableColumn<Flight, Integer> flightHourColumn;

    public ObservableList<Flight> observableListInterested = FXCollections.observableArrayList();

    public void seeInterestedFlights() throws NoFlightsAvailable{
        try {
            fromColumn.setCellValueFactory(new PropertyValueFactory<>("cityA"));
            toColumn.setCellValueFactory(new PropertyValueFactory<>("cityB"));
            flightDateColumn.setCellValueFactory(new PropertyValueFactory<>("flightDate"));
            flightHourColumn.setCellValueFactory(new PropertyValueFactory<>("flightTime"));
            priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
            int interestedFlightsNumber = FlightsService.getInterestedFlightsNumber();
            for (int i = 1; i <= interestedFlightsNumber; i++) {
                Flight flight;
                flight = FlightsService.returnInterestedFlight(i);
                observableListInterested.add(flight);
            }
            flightsTable.setItems(observableListInterested);
        }catch (NoFlightsAvailable e){
            flightsTable.setVisible(false);
            errorMessage.setText(e.getMessage());
        }
    }
}
