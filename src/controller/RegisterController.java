package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.GUIAspect;
import model.RegisterUser;

public class RegisterController {

    RegisterUser registerUser = new RegisterUser();

    @FXML
    private Label notifLabel;

    @FXML
    private TextField nameField;

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    void gobackAction(ActionEvent event) {
        var guiAspect = new GUIAspect();
        guiAspect.loginWindow();
    }

    @FXML
    void submitAction(ActionEvent event) {
        if(registerUser.addUser(nameField.getText(), usernameField.getText(),
                passwordField.getText()))
        {
            notifLabel.setText(nameField.getText() + " was added successfully!");
        }
        else {
            notifLabel.setText("Enter valid input! Also cannot have the same Username as someone else!");
        }
    }

}
