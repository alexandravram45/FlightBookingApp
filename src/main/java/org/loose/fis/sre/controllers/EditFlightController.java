package org.loose.fis.sre.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import org.loose.fis.sre.exceptions.FlightDoesNotExistException;
import org.loose.fis.sre.services.FlightsService;

import static java.sql.Date.valueOf;

public class EditFlightController {

    @FXML

    private TextField cityA, cityB, oldTime, newTime;

    @FXML

    private DatePicker oldDate, newDate;

    @FXML

    private Button editFlight;

    @FXML

    private Text addingMessage;
    @FXML

    public void editFlightButton() {
        try {
            FlightsService.editFlight(cityA.getText(), cityB.getText(), valueOf(oldDate.getValue()), valueOf(newDate.getValue()), oldTime.getText(), newTime.getText());
        } catch (FlightDoesNotExistException e)
        {
            addingMessage.setText(e.getMessage());
        }
    }

}
