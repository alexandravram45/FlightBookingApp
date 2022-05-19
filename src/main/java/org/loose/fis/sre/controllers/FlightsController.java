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
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
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

    public void handleSearch(String cityA2, String cityB2, LocalDate takeOffDate2){
        Flight flight;
        try {
            Calendar date1 = Calendar.getInstance();
            date1.set(takeOffDate2.getYear(), takeOffDate2.getMonthValue(), takeOffDate2.getDayOfMonth());

            flight = FlightsService.searchFlight(cityA2, cityB2, takeOffDate2);

            Calendar c = Calendar.getInstance();
            c.setTime(flight.getTakeOffDate());

            cityA.setText(cityA2);
            cityB.setText(cityB2);
            takeOffDate.setText("" + c.get(Calendar.DAY_OF_MONTH) + "/" + c.get(Calendar.MONTH)  + "/" + (c.get(Calendar.YEAR) - 1900));
            takeOffHour.setText(String.valueOf(flight.getTakeOffHour()));
            price.setText("" + flight.getPrice() + "\u20ac");
        }catch (FlightDoesNotExistException e){
            interestedText.setText(e.getMessage());
        }
    }

    @FXML
    public void addFlightInterested(){
        try{
            FlightsService.addFlightToInterested(cityA.getText(), cityB.getText());
            interestedText.setText("The flight has been successfully added!");
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
                    stage.setScene(new Scene(root, 500, 700));
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
