package org.loose.fis.sre.controllers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;


public class HomeController implements Initializable {

    @FXML
    private Button loginButton;
    @FXML
    private TextField cityA, cityB;
    @FXML
    private DatePicker takeOffDate;
    @FXML
    private Button searchButton;

    public HomeController(){
    }

    @FXML
    public void goToLoginPage() throws Exception {
        loginButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                Parent root;
                try {
                    root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("register.fxml")));
                    Stage stage = new Stage();
                    stage.setTitle("Login");
                    stage.setScene(new Scene(root, 600, 400));
                    stage.show();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @FXML
    public void handleSearchingAction() throws Exception {
        searchButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                Parent root;
                try {
                    root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("flight.fxml")));
                    Stage stage = new Stage();
                    stage.setTitle("Flight");
                    stage.setScene(new Scene(root, 1000, 600));
                    stage.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });
            FlightsController c = new FlightsController();
            c.handleSearch(cityA.getText(), cityB.getText(), takeOffDate.getValue());
            //cityA_static.setText(cityA.getText());
            System.out.println(cityA.getText());

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
