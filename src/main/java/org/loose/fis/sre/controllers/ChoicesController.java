package org.loose.fis.sre.controllers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
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

    private Button addFlight;
    @FXML
    private Button deleteFlight;
    @FXML
    private Button editFlight;

    @FXML

    public void addFlightButton () throws Exception {

        addFlight.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent add) {
                Parent root;
                try {
                    root=FXMLLoader.load(getClass().getClassLoader().getResource("addFlight.fxml"));
                    Stage window = (Stage)((Node) add.getSource()).getScene().getWindow();
                    window.setTitle("Add a flight");
                    window.setScene(new Scene(root,600,460));
                    window.show();
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
            public void handle(ActionEvent delete) {
                Parent root;
                try {
                    root=FXMLLoader.load(getClass().getClassLoader().getResource("deleteFlight.fxml"));
                    Stage window = (Stage)((Node) delete.getSource()).getScene().getWindow();
                    window.setTitle("Delete a flight");
                    window.setScene(new Scene(root,600,460));
                    window.show();
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
            public void handle(ActionEvent edit) {
                Parent root;
                try {
                    root=FXMLLoader.load(getClass().getClassLoader().getResource("editFlight.fxml"));
                    Stage window = (Stage)((Node) edit.getSource()).getScene().getWindow();
                    window.setTitle("Edit a flight");
                    window.setScene(new Scene(root,600,460));
                    window.show();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
