package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TextField;
import model.CSVReaderManager;
import model.GUIAspect;

import java.net.URL;
import java.util.ResourceBundle;

public class ChartController implements Initializable {

    CSVReaderManager csvReaderManager = new CSVReaderManager();
    GUIAspect guiAspect = new GUIAspect();
    XYChart.Series<String, Number> values = new XYChart.Series<String, Number>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        values.setName("Stock");
        xAxis.setAnimated(false);
    }

    @FXML
    private CategoryAxis xAxis;

    @FXML
    private NumberAxis yAxis;

    @FXML
    private LineChart<String, Number> stockChart;

    @FXML
    private TextField tickersymbolField;

    @FXML
    private TextField startdateField;

    @FXML
    private TextField enddateField;

    @FXML
    void gobackAction() {
        guiAspect.homeWindow();
    }

    @FXML
    void searchstockAction(ActionEvent event) {
        csvReaderManager.stockFinder(tickersymbolField.getText(),
                startdateField.getText(), enddateField.getText());

        for(int i=0; i<csvReaderManager.getData().size(); i++) {
            var stockRecord = csvReaderManager.getData().get(i);
            values.getData().add(new XYChart.Data<>(stockRecord.dateProperty().getValue(),
                    stockRecord.closeProperty().getValue()));
        }
        stockChart.getData().add(values);
    }

}
