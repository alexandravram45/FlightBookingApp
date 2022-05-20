package org.loose.fis.sre.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class loginController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private ChoiceBox roleChoice;

    @FXML
    private Button login;

    @FXML
    private Button goToRegister;

    @FXML
    public void initialize() {
        roleChoice.getItems().addAll("Client", "Admin");
    }



}
