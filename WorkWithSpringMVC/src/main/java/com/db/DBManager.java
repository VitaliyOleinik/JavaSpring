package com.db;

import java.util.ArrayList;

public class DBManager {
    private static ArrayList<User>allusers = new ArrayList<>();
    private static Long id = 1L;

    public static void addUser(User u){
        u.setId(id);
        allusers.add(u);
        id++;
    }

    public static ArrayList<User>getAllusers(){
        return allusers;
    }

    public static User getuserById(Long id){
        for(User u: allusers){
            if(u.getId().equals(id)){
                return u;
            }
        }
        return null;
    }
}
