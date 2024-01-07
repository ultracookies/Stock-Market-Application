package model;

import java.util.Date;

public class Home {

    private User user = Main.getCurrentUser();

    private CSVReaderManager csvReaderManager = new CSVReaderManager();

    public boolean sellStock(String tickerSymbol) {
        boolean tag = false;
        if(isValidStock(tickerSymbol)) {
            for(int i=0; i<user.getStocks().size(); i++) {
                if(user.getStocks().get(i).getTickerSymbol().equalsIgnoreCase(tickerSymbol)) {
                    user.getStocks().remove(i);
                    System.out.println("Sucessfully sold " + tickerSymbol + " stock!");
                    user.getPurchaseHistory().add("Sucessfully sold " + tickerSymbol + " stock!");
                    user.setCash(user.getCash() - csvReaderManager.getLatestClosingPrice(tickerSymbol));
                    tag = true;
                    break;
                }
                else {
                    System.out.println("You do not own " + tickerSymbol + " stock!");
                    break;
                }
            }
        }
        else {
            System.out.println("Stock does not exist!");
        }
        return tag;
    }

    private boolean doesStockExist(String tickerSymbol) {
        boolean doesStockExist = false;
        for(int i=0; i<user.getStocks().size(); i++) {
            if(user.getStocks().get(i).getTickerSymbol().equals(tickerSymbol)) {
                doesStockExist =  true;
                break;
            }
        }
        return doesStockExist;
    }

    public boolean buyStock(String tickerSymbol) {
        if (isValidStock(tickerSymbol)) {
            var stocks = user.getStocks();
            var datePurchased = new Date();
            stocks.add(new Stock(tickerSymbol, datePurchased));
            user.setCash(csvReaderManager.getLatestClosingPrice(tickerSymbol) + user.getCash());
            user.getPurchaseHistory().add("Successfully bought " + tickerSymbol + " stock at " + datePurchased + "!");
            System.out.println("Successfully bought " + tickerSymbol + " stock at " + datePurchased + "!");
            return true;
        }
        else {
            System.out.println("Stock does not exist!");
            return false;
        }
    }

    private boolean isValidStock(String tickerSymbol) {
        if(tickerSymbol.equals("") || tickerSymbol.equals(" "))
            return false;
        else
            return true;
    }

    public boolean changePassword(String currentPassword, String newPassword) {
        if(currentPassword.equals(user.getPassword())) {
            user.setPassword(newPassword);
            System.out.println("Password successfully changed!");
            return true;
        }
        else {
            System.out.println("Could not change password.");
            return false;
        }
    }

    /* Tried to calculate the current hold by trying to return the average of different stocks
    but was unable to reach the solution. What you see below is what I have done so far:
     */

//    private double returnCurrentHold() {
//        for(int i=0; i<user.getStocks().size(); i++) {
//
//        }
//    }
//
//    private int numOfDifferentStocks() {
//        int count = 0;
//        for(int i=0; i<user.getStocks().size(); i++) {
//            if(!user.getStocks().get(0).getTickerSymbol().equalsIgnoreCase
//                    (user.getStocks().get(i).getTickerSymbol()))
//            {
//                count++;
//            }
//        }
//        return count;
//    }
//
//    private double returnAverage() {
//        double average = 0.0;
//        for(int i=0; i<user.getStocks().size(); i++) {
//            for(int j=0; j<i; j++) {
//                if(user.getStocks().get(0).getTickerSymbol().equalsIgnoreCase
//                        (user.getStocks().get(j).getTickerSymbol())) {
//                    average++;
//                }
//            }
//            average /= user.getStocks().size();
//        }
//        return average;
//    }
}
