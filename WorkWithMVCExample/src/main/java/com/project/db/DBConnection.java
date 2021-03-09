package com.project.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DBConnection {

    private Connection connection;

    public void connect() {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/group12db?useUnicode=true&serverTimezone=UTC&characterEncoding=utf-8", "root", "");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Cars> getAllCars(){

        ArrayList<Cars> carList = new ArrayList<Cars>();

        try{

            PreparedStatement statement = connection.prepareStatement("SELECT * FROM cars ORDER BY engine_volume DESC");
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                Long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                String model = resultSet.getString("model");
                int maxSpeed = resultSet.getInt("max_speed");
                int year = resultSet.getInt("year");
                double engineVolume = resultSet.getDouble("engine_volume");

                carList.add(new Cars(id, name, model, maxSpeed, year, engineVolume));

            }

            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }

        return carList;

    }

    public Cars getCar(Long id){

        Cars car = null;

        try{

            PreparedStatement statement = connection.prepareStatement("SELECT * FROM cars WHERE id = ? ");
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()){

                String name = resultSet.getString("name");
                String model = resultSet.getString("model");
                int maxSpeed = resultSet.getInt("max_speed");
                int year = resultSet.getInt("year");
                double engineVolume = resultSet.getDouble("engine_volume");

                car = new Cars(id, name, model, maxSpeed, year, engineVolume);

            }

            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }

        return car;

    }

    public void addCar(Cars car){

        try{

            PreparedStatement statement = connection.prepareStatement("" +
                    "INSERT INTO cars (id, name, model, year, max_speed, engine_volume) " +
                    "VALUES (NULL, ?, ?, ?, ?, ?)"
            );

            statement.setString(1, car.getName());
            statement.setString(2, car.getModel());
            statement.setInt(3, car.getYear());
            statement.setInt(4, car.getMaxSpeed());
            statement.setDouble(5, car.getEngineVolume());

            int rows = statement.executeUpdate();

            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
