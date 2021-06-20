package com.example.dringo.dto;

import com.example.dringo.entity.Drink;

import javax.persistence.Column;

public class DrinkDTO {
    private Long id;
    private String name;
    private double price;
    private String description;
    private String picture;

    public DrinkDTO() {
    }

    public static DrinkDTO from(Drink drink){
        DrinkDTO drinkDTO = new DrinkDTO();
        drinkDTO.setId(drink.getId());
        drinkDTO.setName(drink.getName());
        drinkDTO.setDescription(drink.getDescription());
        drinkDTO.setPicture(drink.getPicture());
        return drinkDTO;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
