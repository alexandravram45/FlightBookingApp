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
    private TextField takeOffDate;
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
    public void handleSearchingAction(ActionEvent event) throws Exception {
        searchButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                Parent root;
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("flight.fxml"));
                    root = loader.load();

                    FlightsController flightsController = loader.getController();

                    try{
                        flightsController.handleSearch(cityA.getText(), cityB.getText(), takeOffDate.getText());
                    }catch (NullPointerException e){
                        System.out.println(e.getMessage());
                    }

                    Stage stage = new Stage();
                    stage.setTitle("Flight");
                    stage.setScene(new Scene(root, 1000, 600));
                    stage.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });
    }

    @FXML
    public void seeAllFlights(){

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
