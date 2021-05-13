package com.group11.db;

import org.apache.commons.codec.digest.DigestUtils;

import java.util.ArrayList;

public class DBUtil {

    private ArrayList<Users> users;
    private Long id = 1L;

    private String someParameter;
    private int nextParameter;

    public String getSomeParameter() {
        return someParameter;
    }

    public void setSomeParameter(String someParameter) {
        this.someParameter = someParameter;
    }

    public int getNextParameter() {
        return nextParameter;
    }

    public void setNextParameter(int nextParameter) {
        this.nextParameter = nextParameter;
    }

    public DBUtil(){
        System.out.println("Initializing object");
        users = new ArrayList<Users>();
    }

    public DBUtil(String someParameter){
        users = new ArrayList<Users>();
        this.someParameter = someParameter;
    }

    public DBUtil(String someParameter, int nextParameter) {
        users = new ArrayList<Users>();
        this.someParameter = someParameter;
        this.nextParameter = nextParameter;
    }

    public DBUtil(int nextParameter, String someParameter){
        users = new ArrayList<Users>();
        this.someParameter = someParameter;
        this.nextParameter = nextParameter;
    }

    public void init(){
        System.out.println("Calling init method");
        users.add(new Users(1L, "ilyas@gmail.com", "qwerty", "Ilyas Zhuanyshev"));
        users.add(new Users(2L, "arman@gmail.com", "qwerty", "Arman Zhuanyshev"));
        users.add(new Users(3L, "erzhan@gmail.com", "qwerty", "Erzhan Zhuanyshev"));
        users.add(new Users(4L, "assan@gmail.com", "qwerty", "Assan Zhuanyshev"));
        users.add(new Users(5L, "elnara@gmail.com", "qwerty", "Elnara Galimzhanova"));
        users.add(new Users(6L, "erbolat@gmail.com", "qwerty", "Erbolat Beysembek"));
        id = 7L;
    }

    public Users getUser(String email, String password){

        System.out.println(someParameter);

        for(Users u : users){
            if(u.getEmail().equals(email)&&u.getPassword().equals(password)){
                return u;
            }
        }

        return null;
    }

    public Users getUserByCookie(String cookieData) {

        for (Users u : users) {
            if (cookieData.equals(DigestUtils.sha1Hex(u.getEmail() + "bitlab_" + u.getPassword() + "bitlab"))) {
                return u;
            }
        }

        return null;
    }

    public void addUser(Users user){
        user.setId(id);
        users.add(user);
        id++;
    }

}
