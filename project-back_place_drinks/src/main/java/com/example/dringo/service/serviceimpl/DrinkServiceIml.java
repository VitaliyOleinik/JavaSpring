package com.example.dringo.service.serviceimpl;

import com.example.dringo.dao.DrinkDAO;
import com.example.dringo.entity.Drink;
import com.example.dringo.service.DrinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
@Service
@Transactional
public class DrinkServiceIml implements DrinkService {

    @Autowired
    DrinkDAO drinkDAO;

    @Override
    public void saveDrink(Drink drink) {
        drinkDAO.save(drink);
    }

    @Override
    public List<Drink> getDrinkByName(String name) {
        return drinkDAO.findAllByName(name);
    }

    @Override
    public List<Drink> getAllDrinks() {
        return drinkDAO.findAll();
    }

    @Override
    public Drink getDrink(Long id) {
        Drink drink = null;
        Optional<Drink>optional = drinkDAO.findById(id);
        drink = optional.orElse(null);
        return drink;
    }

    @Override
    public void deleteDrink(Long id) {
        drinkDAO.deleteById(id);
    }
}
