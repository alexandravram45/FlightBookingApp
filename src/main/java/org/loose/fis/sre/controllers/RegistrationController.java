package org.loose.fis.sre.controllers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.loose.fis.sre.exceptions.NotAnAdminException;
import org.loose.fis.sre.exceptions.UsernameAlreadyExistsException;
import org.loose.fis.sre.model.whoIsLoggedIn;
import org.loose.fis.sre.services.UserService;

import java.io.IOException;
import java.util.Objects;

public class RegistrationController {

    @FXML
    private Text registrationMessage;
    @FXML
    private PasswordField passwordField;
    @FXML
    private TextField usernameField;
    @FXML
    private TextField nameField;
    @FXML
    private TextField emailField;
    @FXML
    private TextField numberField;
    @FXML
    private ChoiceBox role;
    private String userRole;

    @FXML
    public void initialize() {
        role.getItems().addAll("Client", "Admin");
    }

    @FXML
    public void handleRegisterAction(ActionEvent event) {
        try {
            UserService.addUser(usernameField.getText(), passwordField.getText(), (String) role.getValue(), nameField.getText(), emailField.getText(), numberField.getText());
            registrationMessage.setText("Account created successfully!");
            userRole = (String) role.getValue();

        } catch (UsernameAlreadyExistsException e1) {
            registrationMessage.setText(e1.getMessage());
        } catch (invalidAdminEmailException e2) {
            registrationMessage.setText(e2.getMessage());
        } catch (invalidCustomerEmailException e3) {
            registrationMessage.setText(e3.getMessage());
        }

    }

    public void goToLogin(javafx.event.ActionEvent login) throws Exception{
        Parent root1=FXMLLoader.load(getClass().getClassLoader().getResource("login.fxml"));
        Stage window = (Stage)((Node)login.getSource()).getScene().getWindow();
        window.setTitle("Login");
        window.setScene(new Scene(root1,600,460));
        window.show();
    }
}
