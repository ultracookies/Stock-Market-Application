package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class CSVReaderManager {

    private ObservableList<StockRecord> data;

    public void stockFinder(String tickerSymbol, String startDate, String endDate) {
        try {
            data = FXCollections.observableArrayList(readCSV(returnUrl2(period(startDate),
                    period(endDate), tickerSymbol), tickerSymbol));
            System.out.println("Searched for " + tickerSymbol + " stock ranging from " +
                    startDate + " to " + endDate + ".");
        }
        catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            System.out.println("Error occurred.");
        }
    }

//    private ArrayList<StockChartRec> readCSV2(String urlStr) {
//        var scrArray = new ArrayList<StockChartRec>();
//        try {
//            URL url = new URL(urlStr);
//            var sc = new Scanner(url.openStream());
//            sc.nextLine();
//            while(sc.hasNextLine()) {
//                var  strArray = sc.nextLine().split(",");
//                scrArray.add(new StockChartRec(strArray[0], strArray[4]));
//            }
//            sc.close();
//        }
//        catch (IOException e) {
//            e.printStackTrace();
//            System.out.println("unable to read csv file");
//        }
//    }

    //This will be the price that the user will buy stocks at since I don't know how to track live prices.
    private double calculateLatestClosingPrice(String urlStr) {
        double latestClosingPrice = 0.0;
        try {
            var url = new URL(urlStr);
            var sc = new Scanner(url.openStream());
            sc.nextLine();
            latestClosingPrice = Double.parseDouble(sc.nextLine().split(",")[4]);
            sc.close();
        }
        catch (IOException e) {
            e.printStackTrace();
            System.out.println("Could not acquire latest closing price from CSV.");
        }
        return latestClosingPrice;
    }

    public double getLatestClosingPrice(String tickerSymbol) {
        var currentDate = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
        return calculateLatestClosingPrice(returnUrl2(period(currentDate)-86400, period(currentDate), tickerSymbol));
    }

    private ArrayList<StockRecord> readCSV(String urlStr, String tickerSymbol) {
        var srArray = new ArrayList<StockRecord>();
        try {
            var url = new URL(urlStr);
            var sc = new Scanner(url.openStream());
            sc.nextLine();
            while(sc.hasNextLine()) {
                var strArray = sc.nextLine().split(",");
                srArray.add(new StockRecord(tickerSymbol, strArray[0], Double.parseDouble(strArray[1]),
                        Double.parseDouble(strArray[2]), Double.parseDouble(strArray[3]),
                        Double.parseDouble(strArray[4]), Double.parseDouble(strArray[5]),
                        Double.parseDouble(strArray[6])));
            }
            sc.close();
        }
        catch (IOException e) {
            e.printStackTrace();
            System.out.println("Unable to read CSV file.");
        }
        return srArray;
    }

    private long period(String date) {
        String[] arr1 = date.split("-");
        int[] arr2 = new int[arr1.length];
        for(int i=0; i<arr2.length; i++) {
            arr2[i] = Integer.parseInt(arr1[i]);
        }
        return calcTimeStamp(arr2[0], arr2[1], arr2[2]);
    }

    private String returnUrl2(long period1, long period2, String tickerSymbol) {
         return "https://query1.finance.yahoo.com/v7/finance/download/" +
                 tickerSymbol + "?period1=" + period1 + "&period2=" +
                 period2 + "&interval=1d&events=history&includeAdjustedClose=true";
    }

    private long calcTimeStamp(int year, int month, int day) {
        long stamp = 0;
        try {
            Calendar cal = Calendar.getInstance();
            cal.set(year, month-1, day, 0,0,0);
            Date date = cal.getTime();
//            var date = new SimpleDateFormat("yyyy-mm-dd").parse(year + "-" + month + "-" + day);
            stamp = date.getTime() / 1000;
        }
        catch (Exception e) {
            System.out.println("Error in calculating time stamp.");
        }
        return stamp;
    }

    public ObservableList<StockRecord> getData() {
        return data;
    }
}
