package com.db;

import com.entities.Cars;

import java.util.List;

public interface CarsDAO {

    void addCar(Cars car);
    List<Cars> getAllCars();

}