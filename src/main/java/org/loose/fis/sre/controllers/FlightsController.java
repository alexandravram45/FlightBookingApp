package org.loose.fis.sre.controllers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.loose.fis.sre.exceptions.FlightDoesNotExistException;
import org.loose.fis.sre.model.Flight;
import org.loose.fis.sre.services.FlightsService;
import org.loose.fis.sre.controllers.HomeController;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Objects;
import java.util.ResourceBundle;

public class FlightsController implements Initializable {
    @FXML
    private Label cityA, cityB, takeOffDate, takeOffBackDate, takeOffHour, takeOffMinutes, price;
    @FXML
    private Text interestedText;
    @FXML
    private Button bookButton;
    private int flightId;

    @FXML
    public void initialize() {
        cityA.setText(" ");
        cityB.setText(" ");
        takeOffDate.setText(" ");
        takeOffBackDate.setText(" ");
        takeOffHour.setText(" ");
        takeOffMinutes.setText(" ");
        price.setText(" ");
    }

    public FlightsController(){
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    public void handleSearch(String cityA2, String cityB2, LocalDate takeOffDate2, LocalDate takeOffBackDate2){
        System.out.println(cityB2);
        Flight flight;
        try {
            flight = FlightsService.searchFlight(cityA2, cityB2, takeOffDate2, takeOffBackDate2);
            this.flightId = flight.getFlightId();
            cityA.setText(cityA2);
            cityB.setText(cityB2);
            takeOffDate.setText(takeOffDate2.toString());
            System.out.println(takeOffDate.getText());
            takeOffBackDate.setText(takeOffBackDate2.toString());
            takeOffHour.setText(String.valueOf(flight.getTakeOffHour()));
            takeOffMinutes.setText(String.valueOf(flight.getTakeOffMinutes()));
            price.setText(String.valueOf(flight.getPrice()));
        }catch (FlightDoesNotExistException e){
            e.getMessage();
        }
    }

    @FXML
    public void addFlightInterested(){
        try{
            FlightsService.addFlightToInterested(flightId);
            interestedText.setText("Zborul a fost adaugat cu succes.");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @FXML
    public void bookThisFlight() throws Exception {

        bookButton.setOnAction(new EventHandler<javafx.event.ActionEvent>() {
            public void handle(ActionEvent event) {
                Parent root;
                try {
                    root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("booking.fxml")));
                    Stage stage = new Stage();
                    stage.setTitle("Booking");
                    stage.setScene(new Scene(root, 500, 800));
                    stage.show();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void showReviews(ActionEvent event) {
    }
}
