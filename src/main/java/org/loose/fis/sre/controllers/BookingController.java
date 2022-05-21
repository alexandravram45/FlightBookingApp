package org.loose.fis.sre.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import org.loose.fis.sre.exceptions.FlightDoesNotExistException;
import org.loose.fis.sre.exceptions.FlightIsFullException;
import org.loose.fis.sre.exceptions.WrongEmailFormatException;
import org.loose.fis.sre.exceptions.WrongPhoneNumberFormatException;
import org.loose.fis.sre.model.Flight;
import org.loose.fis.sre.services.BookingService;
import org.loose.fis.sre.services.FlightsService;

import java.lang.reflect.Field;


public class BookingController {
    @FXML
    private TextField firstName, lastName, tel, address, email;
    @FXML
    private Label cityA, cityB, flightDate, flightHour, price;
    @FXML
    private Text bookingMessage;
    @FXML
    public void handleBookingAction(){
        try {
            BookingService.addBooking(firstName.getText(), lastName.getText(), tel.getText(), address.getText(), email.getText(), cityA.getText(), cityB.getText(), flightDate.getText(), Integer.parseInt(flightHour.getText()), Integer.parseInt(price.getText()));
            bookingMessage.setText("Booking made successfully! Thank You!");
        } catch (WrongEmailFormatException e) {
            bookingMessage.setText(e.getMessage());
        } catch (WrongPhoneNumberFormatException e) {
            bookingMessage.setText(e.getMessage());
        } catch (FlightDoesNotExistException e) {
            bookingMessage.setText(e.getMessage());
        } catch (FlightIsFullException e) {
            bookingMessage.setText(e.getMessage());
        }
    }

    public void setBookingDetails(String cityA2, String cityB2, String flightDate2, int flightHour2, int price2){
        cityA.setText("From: " + cityA2);
        cityB.setText("To: " + cityB2);
        flightDate.setText("Date: " + flightDate2);
        flightHour.setText("Hour: " + flightHour2);
        price.setText("" + price2 + "\u20ac");
    }
}
