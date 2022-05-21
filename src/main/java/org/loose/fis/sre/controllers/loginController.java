package org.loose.fis.sre.controllers;

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
import org.loose.fis.sre.exceptions.EmptyPasswordFieldException;
import org.loose.fis.sre.exceptions.EmptyUsernameFieldException;
import org.loose.fis.sre.exceptions.UsernameDoesNotExistException;
import org.loose.fis.sre.exceptions.WrongPasswordException;
import org.loose.fis.sre.services.UserService;

public class loginController {

    @FXML
    private Text loginMessage;
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

    private String userRole;

    @FXML
    public void initialize() {
        roleChoice.getItems().addAll("Client", "Admin");
    }

    public void handleLoginAction(javafx.event.ActionEvent login) throws Exception{
        try {
            UserService.checkLoginInfo(usernameField.getText(), passwordField.getText(), (String) roleChoice.getValue());
            loginMessage.setText("Login succesful!");
            userRole=(String) roleChoice.getValue();
            if(userRole.equals("Admin")){
                Parent root2 = FXMLLoader.load(getClass().getClassLoader().getResource("adminChoices.fxml"));
                Stage window = (Stage) ((Node) login.getSource()).getScene().getWindow();
                ;
                window.setTitle("Admin");
                window.setScene(new Scene(root2, 600, 400));
                window.show();
            } else if (userRole.equals("Client")) {
                Parent root3 = FXMLLoader.load(getClass().getClassLoader().getResource("home.fxml"));
                Stage window = (Stage) ((Node) login.getSource()).getScene().getWindow();
                ;
                window.setTitle("Home");
                window.setScene(new Scene(root3, 600, 400));
                window.show();

            }
        } catch (UsernameDoesNotExistException e) {
            loginMessage.setText(e.getMessage());
        } catch (EmptyUsernameFieldException e) {
            loginMessage.setText(e.getMessage());
        } catch (EmptyPasswordFieldException e) {
            loginMessage.setText(e.getMessage());
        }catch (WrongPasswordException e) {
            loginMessage.setText(e.getMessage());
        }
    }
    public void goBackToRegisterScene(javafx.event.ActionEvent login) throws Exception {
        Parent root1 = FXMLLoader.load(getClass().getClassLoader().getResource("register.fxml"));
        Stage window = (Stage) ((Node) login.getSource()).getScene().getWindow();
        ;
        window.setTitle("Register");
        window.setScene(new Scene(root1, 600, 400));
        window.show();
    }
}
