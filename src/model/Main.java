package model;

import javafx.application.Application;
import javafx.stage.Stage;

import java.io.*;

public class Main extends Application {

    private static DataCenter dataCenter;
    private static User currentUser;
    private static Stage stage = new Stage();

    public static Stage getStage() {
        return stage;
    }

    public static User getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(User currentUser) {
        Main.currentUser = currentUser;
    }

    @Override
    public void init() {
        try {
            var file = new File("data.dat");
            if (!file.exists()) {
                file.createNewFile();
                dataCenter = new DataCenter();
            }
            else {
                var fileIn = new FileInputStream(file);
                var objIn = new ObjectInputStream(fileIn);
                dataCenter = (DataCenter) objIn.readObject();
                objIn.close();
                fileIn.close();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Could not load data.");
            dataCenter = new DataCenter();
        }
    }

    @Override
    public void stop() {
        if(getCurrentUser() != null) {
            try {
                var file = new File("data.dat");
                var fileOut = new FileOutputStream(file, true);
                var objOut = new ObjectOutputStream(fileOut);
                objOut.writeObject(dataCenter);
                objOut.close();
                fileOut.close();
            }
            catch (Exception e) {
                e.printStackTrace();
                System.out.println("Could not send data to file.");
            }
        }
        else
            System.out.println("Current user is null");
    }

    @Override
    public void start(Stage primaryStage) {
        var gui = new GUIAspect();
        gui.loginWindow();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static DataCenter getDataCenter() {
        return dataCenter;
    }
}
