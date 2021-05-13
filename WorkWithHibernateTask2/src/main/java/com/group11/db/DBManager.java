package com.group11.db;

import org.apache.commons.codec.digest.DigestUtils;

import java.util.ArrayList;

public class DBManager {

    private static ArrayList<Users> users = new ArrayList<Users>();
    static {
        users.add(new Users(1L, "erba@gmail.com", "qwerty", "Erbolat Erba"));
        users.add(new Users(2L, "zhanbo@gmail.com", "qwerty", "Zhanbolat Erba"));
        users.add(new Users(3L, "nurbo@gmail.com", "qwerty", "Nurbolat Erba"));
        users.add(new Users(4L, "erzhan@gmail.com", "qwerty", "Erzhan Erba"));
        users.add(new Users(5L, "assan@gmail.com", "qwerty", "Assan Erba"));
        users.add(new Users(6L, "hassan@gmail.com", "qwerty", "Hassan Erba"));
    }

    public static Users getUser(String email, String password){

        for(Users u : users){
            if(u.getEmail().equals(email)&&u.getPassword().equals(password)){
                return u;
            }
        }

        return null;

    }

    public static Users getUserByCookie(String cookieData){

        for(Users u : users){
            if(cookieData.equals(DigestUtils.sha1Hex(u.getEmail()+"bitlab_"+u.getPassword()+"bitlab"))){
                return u;
            }
        }

        return null;

    }

}
