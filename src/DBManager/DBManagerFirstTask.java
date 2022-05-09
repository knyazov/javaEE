package DBManager;

import first_task.User;

import java.util.ArrayList;

public class DBManagerFirstTask {
    private static ArrayList<User> getUser = new ArrayList<>();


    public static void addUser(User user){
        getUser.add(user);
    }

    public static ArrayList<User> getUser(){
        return getUser;
    }
}
