package model;

import javafx.beans.property.SimpleStringProperty;

import java.io.Serializable;
import java.util.Date;

public class Stock implements Serializable {
    private String tickerSymbol;
    private Date datePurchased;

    public Stock(String tickerSymbol, Date datePurchased) {
        this.tickerSymbol = tickerSymbol;
        this.datePurchased = datePurchased;
    }

    public SimpleStringProperty tickerSymbolProperty() {
        return new SimpleStringProperty(tickerSymbol);
    }

    public String getTickerSymbol() {
        return tickerSymbol;
    }

    public void setTickerSymbol(String tickerSymbol) {
        this.tickerSymbol = tickerSymbol;
    }

    public Date datePurchasedProperty() {
        return datePurchased;
    }

    public Date getDatePurchased() {
        return datePurchased;
    }

    public void setDatePurchased(Date datePurchased) {
        this.datePurchased = datePurchased;
    }
}
