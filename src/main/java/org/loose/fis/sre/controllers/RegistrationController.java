package org.loose.fis.sre.controllers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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
    private ChoiceBox role;
    private String userRole;

    @FXML
    public void initialize() {
        role.getItems().addAll("Client", "Admin");
    }

    @FXML
    public void handleRegisterAction(ActionEvent event) {
        try {
            UserService.addUser(usernameField.getText(), passwordField.getText(), (String) role.getValue());
            registrationMessage.setText("Account created successfully!");
            userRole = (String) role.getValue();
            if (userRole.equals("Admin")){
                whoIsLoggedIn.setLoggedUsername(usernameField.getText());
                Parent root;
                try {
                    root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("adminChoices.fxml")));
                    Stage stage = new Stage();
                    stage.setTitle("Choose options");
                    stage.setScene(new Scene(root, 600, 400));
                    stage.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }else if (userRole.equals("Customer")){
                whoIsLoggedIn.setLoggedUsername(usernameField.getText());
                Parent root;
                try {
                    root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("home.fxml")));
                    Stage stage = new Stage();
                    stage.setTitle("Home page");
                    stage.setScene(new Scene(root, 1000, 600));
                    stage.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (UsernameAlreadyExistsException e) {
            registrationMessage.setText(e.getMessage());
        } catch (NotAnAdminException e){
            registrationMessage.setText(e.getMessage());
        }
    }
}
