package org.loose.fis.sre.controllers;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.loose.fis.sre.exceptions.FlightAlreadyExistsException;
import org.loose.fis.sre.exceptions.NotAnAdminException;
import org.loose.fis.sre.exceptions.UsernameAlreadyExistsException;
import org.loose.fis.sre.model.Flight;
import org.loose.fis.sre.services.FlightsService;
import org.loose.fis.sre.services.UserService;

import static java.sql.Date.valueOf;
import static org.loose.fis.sre.services.FlightsService.flightRepository;

public class AddFlightController {

    @FXML
    private TextField cityA, cityB, price, time;

    @FXML
    private TextField takeOffDate;

    @FXML
    private Button addFlight;

    @FXML
    private Button goBack;

    @FXML
    private Text addingMessage;

    @FXML
    public void addFlightButton() {
        try {
            setId();
            FlightsService.addFlight(cityA.getText(), cityB.getText(), takeOffDate.getText(), Integer.parseInt(time.getText()), Integer.parseInt(price.getText()));
            addingMessage.setText("The flight has been added successfully");
        } catch (FlightAlreadyExistsException e) {
            addingMessage.setText(e.getMessage());
        }
    }

    private void setId() {
        int max = 0;
        for (Flight flight : flightRepository.find()) {
            if (flight.getId() > max)
                max = flight.getId();
        }
        Flight.setCurrentid(max);
    }

    public void goBackButton(javafx.event.ActionEvent back) throws Exception {
        Parent root1 = FXMLLoader.load(getClass().getClassLoader().getResource("adminChoices.fxml"));
        Stage window = (Stage) ((Node) back.getSource()).getScene().getWindow();
        window.setTitle("Admin");
        window.setScene(new Scene(root1, 600, 460));
        window.show();
    }
}
