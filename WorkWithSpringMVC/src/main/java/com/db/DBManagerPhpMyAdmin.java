package com.db;

import com.entites.Users;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DBManagerPhpMyAdmin {
    private Connection connection;

    public DBManagerPhpMyAdmin(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/spring_test_db?serverTimezone=UTC&characterEncoding=UTF8", "root", "");

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public ArrayList<Users> getAllUsers(){
        ArrayList<Users> allUsers = new ArrayList<>();
        try{
            PreparedStatement statement = connection.prepareStatement("Select * from users");
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                allUsers.add(new Users(
                        resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getString("surname"),
                        resultSet.getInt("age")
                ));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return allUsers;
    }

    public void addUser(Users user){
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "INSERT INTO users (id, name, surname, age) " +
                    "VALUES (NULL, ?, ?, ?)");
            statement.setString(1, user.getName());
            statement.setString(2, user.getSurname());
            statement.setInt(3, user.getAge());

            statement.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public Users getUserById(Long id){
        Users user = null;
        try{
            PreparedStatement statement = connection.prepareStatement("select * from users where id = ?");
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()){
                user = (new Users(
                        resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getString("surname"),
                        resultSet.getInt("age")
                ));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return user;
    }
}
