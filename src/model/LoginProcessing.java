package model;

import java.util.ArrayList;

public class LoginProcessing {

    private boolean isLoggedIn = false;
    private ArrayList<User> users = Main.getDataCenter().getUsers();

    public boolean processInput(String username, String password) {
        for(User user : users) {
            if(username.equals(user.getUsername())
                    && password.equals(user.getPassword()))
            {
                isLoggedIn = true;
                user.setCurrentUser(true);
                Main.setCurrentUser(user);
                System.out.println("Access granted for " + username + ".");
                break;
            }
            else {
                System.out.println("Access denied.");
                isLoggedIn = false;
            }
        }
        return isLoggedIn;
    }

    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        isLoggedIn = loggedIn;
    }
}
