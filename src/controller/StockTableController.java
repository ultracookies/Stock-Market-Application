package controller;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.CSVReaderManager;
import model.GUIAspect;
import model.StockRecord;

import java.net.URL;
import java.util.ResourceBundle;

public class StockTableController implements Initializable {

    CSVReaderManager CSVReaderManager = new CSVReaderManager();
    GUIAspect guiAspect = new GUIAspect();

    @FXML
    private TableView<StockRecord> stocktableView;

    @FXML
    private TableColumn<StockRecord, SimpleStringProperty> tickerSymbolCol;

    @FXML
    private TableColumn<StockRecord, SimpleStringProperty> dateCol;

    @FXML
    private TableColumn<StockRecord, SimpleDoubleProperty> openCol;

    @FXML
    private TableColumn<StockRecord, SimpleDoubleProperty> highCol;

    @FXML
    private TableColumn<StockRecord, SimpleDoubleProperty> lowCol;

    @FXML
    private TableColumn<StockRecord, SimpleDoubleProperty> closeCol;

    @FXML
    private TableColumn<StockRecord, SimpleDoubleProperty> adjCloseCol;

    @FXML
    private TableColumn<StockRecord, SimpleDoubleProperty> volumeCol;

    @FXML
    private TextField tickersymbolField;

    @FXML
    private TextField startdateField;

    @FXML
    private TextField enddateField;

    @FXML
    void gobackAction(ActionEvent event) {
        guiAspect.homeWindow();
    }

    @FXML
    void searchstockAction(ActionEvent event) {
        CSVReaderManager.stockFinder(tickersymbolField.getText(),
                startdateField.getText(), enddateField.getText());

        stocktableView.setItems(CSVReaderManager.getData());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setTableColumns();
    }

    private void setTableColumns() {
        tickerSymbolCol.setCellValueFactory(new PropertyValueFactory<>("tickerSymbol"));
        dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
        openCol.setCellValueFactory(new PropertyValueFactory<>("open"));
        highCol.setCellValueFactory(new PropertyValueFactory<>("high"));
        lowCol.setCellValueFactory(new PropertyValueFactory<>("low"));
        closeCol.setCellValueFactory(new PropertyValueFactory<>("close"));
        adjCloseCol.setCellValueFactory(new PropertyValueFactory<>("adjclose"));
        volumeCol.setCellValueFactory(new PropertyValueFactory<>("volume"));
    }
}
