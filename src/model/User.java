package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class User implements Serializable {
    private String name;
    private String username;
    private String password;
    private ArrayList<Stock> stocks = new ArrayList<Stock>();
//    private ObservableList<String> purchaseHistory = FXCollections.observableArrayList(new ArrayList<String>());
    private ArrayList<String> purchaseHistory = new ArrayList<String>();
    private double cash;
    private boolean isCurrentUser;

    final private static long serialVersionUUID = 1l;

    public User(String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<Stock> getStocks() {
        return stocks;
    }

    public boolean isCurrentUser() {
        return isCurrentUser;
    }

    public void setCurrentUser(boolean currentUser) {
        isCurrentUser = currentUser;
    }

    public double getCash() {
        return cash;
    }

    public void setCash(double cash) {
        this.cash = cash;
    }

//    public ObservableList<String> getPurchaseHistory() {
//        return purchaseHistory;
//    }
//
//    public void setPurchaseHistory(ObservableList<String> purchaseHistory) {
//        this.purchaseHistory = purchaseHistory;
//    }

    public ObservableList<String> getPurchaseHistory1() {
        return FXCollections.observableArrayList(getPurchaseHistory());
    }

    public String moneyFormat() {
        return NumberFormat.getCurrencyInstance(Locale.US).format(Math.abs(cash));
    }

    public ArrayList<String> getPurchaseHistory() {
        return purchaseHistory;
    }

    public void setPurchaseHistory(ArrayList<String> purchaseHistory) {
        this.purchaseHistory = purchaseHistory;
    }
}
