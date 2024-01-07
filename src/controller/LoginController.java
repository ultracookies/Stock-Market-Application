package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.GUIAspect;
import model.LoginProcessing;

public class LoginController {

    GUIAspect guiAspect = new GUIAspect();

    @FXML
    private Label notifLabel;

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    void loginAction(ActionEvent event) {
        var loginProcessor = new LoginProcessing();
        if(loginProcessor.processInput(usernameField.getText(), passwordField.getText())) {
            guiAspect.homeWindow();
        }
        else {
            notifLabel.setText("Wrong information!");
        }
    }

    @FXML
    void registerAction(ActionEvent event) {
        guiAspect.registerWindow();
    }
}
