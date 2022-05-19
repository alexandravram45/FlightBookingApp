package org.loose.fis.sre.controllers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class ChoicesController {

    @FXML

    private TextField choicesText;

    @FXML

    private Button addFlight, deleteFlight, editFlight;

    @FXML

    public void addFlightButton () throws Exception {

        addFlight.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                Parent root;
                try {
                    root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("addFlight.fxml")));
                    Stage stage = new Stage();
                    stage.setTitle("Add Flight");
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

    public void deleteFlightButton () throws Exception {

        deleteFlight.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                Parent root;
                try {
                    root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("deleteFlight.fxml")));
                    Stage stage = new Stage();
                    stage.setTitle("Delete Flight");
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

    public void editFlightButton () throws Exception {

        editFlight.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                Parent root;
                try {
                    root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("editFlight.fxml")));
                    Stage stage = new Stage();
                    stage.setTitle("Edit Flight");
                    stage.setScene(new Scene(root, 600, 400));
                    stage.show();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
