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



public class DeleteFlightController {

    @FXML
    private TextField cityA, cityB, flightTime;

    @FXML
    private TextField flightDate;

    @FXML
    private Text deleteMessage;

    @FXML
    private Button goBack;

    @FXML
    private Button deleteFlight;

    public void deleteFlightButton() {

        try {
            FlightsService.deleteFlight(cityA.getText(), cityB.getText());
            deleteMessage.setText("The flight has been deleted successfully");
        } catch (FlightDoesNotExistException e) {
            deleteMessage.setText(e.getMessage());
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
