package org.loose.fis.sre.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import org.loose.fis.sre.exceptions.FlightDoesNotExistException;
import org.loose.fis.sre.services.FlightsService;



public class DeleteFlightController {

    @FXML

    private TextField cityA, cityB, flightTime;

    @FXML

    private DatePicker flightDate;

    @FXML

    private Text deleteMessage;

    public void deleteFlightButton() {

        try {
            FlightsService.deleteFlight(cityA.getText(), cityB.getText());
            deleteMessage.setText("The flight has been deleted successfully");
        } catch (FlightDoesNotExistException e) {
            deleteMessage.setText(e.getMessage());
        }
    }

}
