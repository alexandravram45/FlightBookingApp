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
import org.loose.fis.sre.exceptions.FlightDoesNotExistException;
import org.loose.fis.sre.services.FlightsService;

import static java.sql.Date.valueOf;

public class EditFlightController {

    @FXML
    private TextField cityA, cityB, oldTime, newTime;

    @FXML
    private TextField oldDate, newDate;

    @FXML
    private Button editFlight;

    @FXML
    private Button goBack;

    @FXML
    private Text addingMessage;
    @FXML

    public void editFlightButton() {
        try {
            FlightsService.editFlight(cityA.getText(), cityB.getText(), oldDate.getText(), newDate.getText(), Integer.parseInt(oldTime.getText()), Integer.parseInt(newTime.getText()));
        } catch (FlightDoesNotExistException e)
        {
            addingMessage.setText(e.getMessage());
        }
    }
    public void goBackButton(javafx.event.ActionEvent back) throws Exception{
        Parent root1= FXMLLoader.load(getClass().getClassLoader().getResource("adminChoices.fxml"));
        Stage window = (Stage)((Node)back.getSource()).getScene().getWindow();
        window.setTitle("Admin");
        window.setScene(new Scene(root1,600,460));
        window.show();
    }
}
