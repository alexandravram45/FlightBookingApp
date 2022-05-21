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
import org.loose.fis.sre.model.Review;
import org.loose.fis.sre.services.FlightsService;
import org.loose.fis.sre.controllers.HomeController;
import org.loose.fis.sre.services.ReviewsService;

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
    private Label cityA, cityB, takeOffDate, takeOffHour, price;
    @FXML
    private Text interestedText;
    @FXML
    private Button bookButton;
    @FXML
    private Label personName;
    @FXML
    private Text personReview;
    @FXML
    private Pane reviewPane;

    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cityA.setText(" ");
        cityB.setText(" ");
        takeOffDate.setText(" ");
        takeOffHour.setText(" ");
        price.setText(" ");
        reviewPane.setVisible(false);
    }

    public FlightsController(){
    }

    public void handleSearch(String cityA2, String cityB2, String takeOffDate2){
        Flight flight;
        try {
            flight = FlightsService.searchFlight(cityA2, cityB2, takeOffDate2);
            cityA.setText(cityA2);
            cityB.setText(cityB2);
            takeOffDate.setText(flight.getFlightDate());
            takeOffHour.setText(String.valueOf(flight.getFlightTime()));
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
                String s = price.getText();

                int priceValue = Integer.parseInt(s.replaceAll("[^0-9]", ""));
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("booking.fxml"));
                    root = loader.load();

                    BookingController bookingController = loader.getController();
                    bookingController.setBookingDetails(cityA.getText(), cityB.getText(), takeOffDate.getText(), Integer.parseInt(takeOffHour.getText()), priceValue);

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
    @FXML
    public void showReviews(ActionEvent event) {
        reviewPane.setVisible(true);
        personReview.setWrappingWidth(590);
        Review review = ReviewsService.addReviews(cityB.getText());
        personReview.setText(review.getReviewText());
        personName.setText(review.getPersonName());
    }
}
