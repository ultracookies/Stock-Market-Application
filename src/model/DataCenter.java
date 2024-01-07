package model;

import java.io.Serializable;
import java.util.ArrayList;

public class DataCenter implements Serializable {
    private final ArrayList<User> users = new ArrayList<>();

    public ArrayList<User> getUsers() {
        return users;
    }
}
