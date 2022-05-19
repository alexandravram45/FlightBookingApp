package org.loose.fis.sre.controllers;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import org.loose.fis.sre.exceptions.FlightAlreadyExistsException;
import org.loose.fis.sre.exceptions.NotAnAdminException;
import org.loose.fis.sre.exceptions.UsernameAlreadyExistsException;
import org.loose.fis.sre.model.Flight;
import org.loose.fis.sre.services.FlightsService;
import org.loose.fis.sre.services.UserService;

import static java.sql.Date.valueOf;

public class AddFlightController {

    @FXML

    private TextField cityA, cityB, price, time;

    @FXML

    private TextField takeOffDate;

    @FXML

    private Button addFlight;

    @FXML

    private Text addingMessage;

    @FXML
    public void addFlightButton() {
        try {
            FlightsService.addFlight(cityA.getText(), cityB.getText(), takeOffDate.getText(), Integer.parseInt(price.getText()), Integer.parseInt(time.getText()));
            addingMessage.setText("The flight has been added successfully");
        } catch (FlightAlreadyExistsException e) {
            addingMessage.setText(e.getMessage());
        }
    }
}
