package com.group11.beans;

import com.group11.db.Users;
import org.apache.commons.codec.digest.DigestUtils;

import java.sql.*;

public class UserBean {

    private Connection connection;
    private String url;
    private String userName;
    private String password;

    public UserBean() {
    }

    public UserBean(String url, String userName, String password) {
        this.url = url;
        this.userName = userName;
        this.password = password;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void connect(){
        try{

            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, userName, password);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public Users getUser(String email, String password){
        try{

            PreparedStatement statement =
                    connection.prepareStatement("SELECT * FROM users WHERE email = ? AND password = ? ");

            statement.setString(1, email);
            statement.setString(2, password);

            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()){

                return new Users(resultSet.getLong("id"), email, password, resultSet.getString("full_name"));

            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public Users getUserByCookie(String cookieData) {

        try{

            PreparedStatement statement =
                    connection.prepareStatement("SELECT * FROM users WHERE SHA1(CONCAT(CONCAT(email, \"bitlab_\"), CONCAT(password, \"bitlab\"))) = ?");

            statement.setString(1, cookieData);

            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()){

                return new Users(resultSet.getLong("id"), resultSet.getString("email"), resultSet.getString("password"), resultSet.getString("full_name"));

            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

}
