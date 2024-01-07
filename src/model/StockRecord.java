package model;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

public class StockRecord {
    private SimpleStringProperty tickerSymbol;
    private SimpleStringProperty date;
    private SimpleDoubleProperty open;
    private SimpleDoubleProperty high;
    private SimpleDoubleProperty low;
    private SimpleDoubleProperty close;
    private SimpleDoubleProperty adjclose;
    private SimpleDoubleProperty volume;

    public StockRecord(String tickerSymbol, String date, double open, double high, double low,
                       double close, double adjclose, double volume) {
        this.tickerSymbol = new SimpleStringProperty(tickerSymbol);
        this.setDate(new SimpleStringProperty(date));
        this.setOpen(new SimpleDoubleProperty(open));
        this.setHigh(new SimpleDoubleProperty(high));
        this.setLow(new SimpleDoubleProperty(low));
        this.setClose(new SimpleDoubleProperty(close));
        this.setAdjclose(new SimpleDoubleProperty(adjclose));
        this.setVolume(new SimpleDoubleProperty(volume));
    }

    public SimpleStringProperty tickerSymbolProperty() {
        return tickerSymbol;
    }

    public void setTickerSymbol(SimpleStringProperty tickerSymbol) {
        this.tickerSymbol = tickerSymbol;
    }

    public SimpleStringProperty dateProperty() {
        return date;
    }

    public void setDate(SimpleStringProperty date) {
        this.date = date;
    }

    public SimpleDoubleProperty openProperty() {
        return open;
    }

    public void setOpen(SimpleDoubleProperty open) {
        this.open = open;
    }

    public SimpleDoubleProperty highProperty() {
        return high;
    }

    public void setHigh(SimpleDoubleProperty high) {
        this.high = high;
    }

    public SimpleDoubleProperty lowProperty() {
        return low;
    }

    public void setLow(SimpleDoubleProperty low) {
        this.low = low;
    }

    public SimpleDoubleProperty closeProperty() {
        return close;
    }

    public void setClose(SimpleDoubleProperty close) {
        this.close = close;
    }

    public SimpleDoubleProperty adjcloseProperty() {
        return adjclose;
    }

    public void setAdjclose(SimpleDoubleProperty adjclose) {
        this.adjclose = adjclose;
    }

    public SimpleDoubleProperty volumeProperty() {
        return volume;
    }

    public void setVolume(SimpleDoubleProperty volume) {
        this.volume = volume;
    }

    public double getClose() {
        return close.getValue();
    }
}