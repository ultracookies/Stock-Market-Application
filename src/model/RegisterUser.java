package model;

import java.util.ArrayList;

public class RegisterUser {
    ArrayList<User> users = Main.getDataCenter().getUsers();

    public boolean addUser(String name, String username, String password) {
        if(validateInput(name, username, password)) {
            users.add(new User(name, username, password));
            System.out.println("User successfully added!");
            return true;
        }
        else
            return false;
    }

    private boolean validateInput(String name, String username, String password) {
        if (name.isEmpty() || name.isBlank()) return false;
        if (username.isBlank() || username.isEmpty()) return false;
        if (password.isBlank() || password.isEmpty()) return false;
        if (!users.isEmpty()) {
            for (var user : users) {
                if (username.equals(user.getUsername())) return false;
            }
        }
        return true;
    }

//    private boolean validateInput(String name, String username, String password) {
//        boolean isValid = false;
//        for(User user : users) {
//            if (username.equals(user.getUsername()) ||
//                    (username.isBlank() && username.isEmpty()) ||
//                    (password.isBlank()) && password.isEmpty())
//            {
//                System.out.println("Enter valid input!" +
//                        "\nAlso cannot have the same Username as someone else!");
//                break;
//            }
//            else
//                isValid = true;
//        }
//        return isValid;
//    }
}
