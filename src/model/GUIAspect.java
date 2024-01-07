package model;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class GUIAspect {

    Stage stage = Main.getStage();

    public void chartWindow() {
        stage.setTitle("Chart");
        Pane chart;
        try {
            chart = FXMLLoader.load(getClass().getResource("../view/Chart.fxml"));
            stage.setScene(new Scene(chart));
            stage.show();
        }
        catch (IOException e) {
            e.printStackTrace();
            System.out.println("Unable to load chart window.");
        }
    }

    public void homeWindow() {
        stage.setTitle("Home");
        Pane home;
        try {
            home = FXMLLoader.load(getClass().getResource("../view/Home.fxml"));
            stage.setScene(new Scene(home));
            stage.show();
        }
        catch (IOException e) {
            e.printStackTrace();
            System.out.println("Unable to load home window.");
        }
    }

    public void registerWindow() {
        stage.setTitle("Register");
        Pane register;
        try {
            register = FXMLLoader.load(getClass().getResource("../view/Register.fxml"));
            stage.setScene(new Scene(register));
            stage.show();
        }
        catch (IOException e) {
            e.printStackTrace();
            System.out.println("Unable to load register window.");
        }
    }

    public void displayStockTable() {
        stage.setTitle("Stock Table");
        Pane stockTable;
        try {
            stockTable = FXMLLoader.load(getClass().getResource("../view/StockTable.fxml"));
            stage.setScene(new Scene(stockTable));
            stage.show();
        }
        catch (IOException e) {
            e.printStackTrace();
            System.out.println("Unable to load stock table.");
        }
    }

    public void loginWindow() {
        stage.setTitle("Login");
        Pane login;
        try {
            login = FXMLLoader.load(getClass().getResource("../view/Login.fxml"));
            stage.setScene(new Scene(login));
            stage.show();
        }
        catch (IOException e) {
            e.printStackTrace();
            System.out.println("Unable to load login window.");
        }
    }
}
