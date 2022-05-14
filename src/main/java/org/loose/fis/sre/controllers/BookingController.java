package org.loose.fis.sre.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import org.loose.fis.sre.exceptions.WrongEmailFormatException;
import org.loose.fis.sre.exceptions.WrongPhoneNumberFormatException;
import org.loose.fis.sre.services.BookingService;


public class BookingController {
    @FXML
    private TextField firstName, lastName, tel, address, email;
    @FXML
    private Text bookingMessage;
    @FXML
    public void handleBookingAction(){
        try {
            BookingService.addBooking(firstName.getText(), lastName.getText(), tel.getText(), address.getText(), email.getText());
            bookingMessage.setText("Booking made successfully! Thank You!");
        } catch (WrongEmailFormatException e) {
            bookingMessage.setText(e.getMessage());
        } catch (WrongPhoneNumberFormatException e) {
            bookingMessage.setText(e.getMessage());
        }
    }
}
