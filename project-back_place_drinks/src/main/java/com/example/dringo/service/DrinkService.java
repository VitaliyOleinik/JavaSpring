package com.example.dringo.service;

import com.example.dringo.entity.Drink;
import com.example.dringo.entity.Place;

import java.util.List;

public interface DrinkService {
    public void saveDrink(Drink drink);

    public List<Drink> getDrinkByName(String name);

    public List<Drink> getAllDrinks();

    public Drink getDrink(Long id);

    public void deleteDrink(Long id);
}
