package com.example.dringo.controller;

import com.example.dringo.dto.DrinkDTO;
import com.example.dringo.entity.Drink;
import com.example.dringo.entity.Place;
import com.example.dringo.service.DrinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DrinkController {
    @Autowired
    DrinkService drinkService;

    @PostMapping("/drinks")
    public ResponseEntity<DrinkDTO> createDrink(@RequestBody final  DrinkDTO drinkDTO){
        return drinkDTO;
    }

    @GetMapping("/drinks/{id}")
    public Drink getDrinkByName(@PathVariable Long id){
        return drinkService.getDrink(id);
    }

    @GetMapping ("/drinks")
    public List<Drink> getAllDrinks(){
        return drinkService.getAllDrinks();
    }

    @PutMapping ("/drinks")
    public String updateDrink(@RequestBody Drink drink){
        drinkService.saveDrink(drink);
        return "the drink was updated " + drink.toString();
    }

    @DeleteMapping ("/drinks/{id}")
    public String deleteDrink(@PathVariable Long id){
        drinkService.deleteDrink(id);
        return "the drink was deleted which id is: " + id;
    }
}
