package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.*;

import java.net.URL;
import java.util.ResourceBundle;

public class HomeController implements Initializable {

    User user = Main.getCurrentUser();
    GUIAspect guiAspect = new GUIAspect();
    Home home = new Home();

    @FXML
    private ListView<String> purchaseHistoryView;

    @FXML
    private PasswordField currentpasswordField;

    @FXML
    private TextField newpasswordField;

    @FXML
    private TextField tickersymbolField;

    @FXML
    private Label nameLabel;

    @FXML
    private Label unameLabel;

    @FXML
    private Label passwordNotifLabel;

    @FXML
    private Label cashAmount;

    @FXML
    void changepasswordAction(ActionEvent event) {
        if(home.changePassword(currentpasswordField.getText(), newpasswordField.getText())
        && !(newpasswordField.getText().equals("") || newpasswordField.getText().equals(" ")))
        {
            passwordNotifLabel.setText("Password successfully changed!");
        }
        else
            passwordNotifLabel.setText("Password could not be changed.");
    }

    @FXML
    void logoutAction(ActionEvent event) {
        guiAspect.loginWindow();
    }

    @FXML
    void viewstocktableAction(ActionEvent event) {
        guiAspect.displayStockTable();
    }

    @FXML
    void viewchartAction(ActionEvent event) {
        guiAspect.chartWindow();
    }

    @FXML
    void buyAction() {
        if(home.buyStock(tickersymbolField.getText())) {
            addToList(true);
            cashAmount.setText(user.moneyFormat());

        }
        else {
            purchaseHistoryView.getItems().add("Unable to buy " +
                    tickersymbolField.getText() + " stock.");
        }
    }

    @FXML
    void sellAction() {
        if(home.sellStock(tickersymbolField.getText())) {
            //addToList(false);
            refreshPurchaseHistoryList();
            cashAmount.setText(user.moneyFormat());
        }
        else {
            user.getPurchaseHistory().add("You do not own " +
                    tickersymbolField.getText() + " stock.");

            purchaseHistoryView.getItems().add("You do not own " +
                    tickersymbolField.getText() + " stock.");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        nameLabel.setText(user.getName());
        unameLabel.setText(user.getUsername());
        cashAmount.setText(user.moneyFormat());
        purchaseHistoryView.setItems(user.getPurchaseHistory1());
    }

    private void refreshPurchaseHistoryList() {
        purchaseHistoryView.setItems(user.getPurchaseHistory1());
    }

    private void addToList(boolean isBought) {
        String boughtOrSold = isBought ? "bought" : "sold";
        purchaseHistoryView.getItems().add("Successfully " + boughtOrSold + " " +
                tickersymbolField.getText() + " stock!");
    }

}
