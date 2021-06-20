package com.example.dringo.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "places")
public class Place {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "location")
    private String location;
    @Column(name = "picture")
    private String picture;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY, mappedBy = "place")
    @JsonManagedReference
    private List<Drink> drinks;

    public Place() {
    }

    public Place(String name, String location, String picture) {
        this.name = name;
        this.location = location;
        this.picture = picture;
    }

    public void addDrinkToPlace(Drink drink){
        if(drinks == null){ drinks = new ArrayList<>(); }
        drinks.add(drink);
        drink.setPlace(this);
    }

    public void removeDrinkFromPlace(Drink drink){
        drinks.remove(drink);
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public List<Drink> getDrinks() {
        return drinks;
    }

    public void setDrinks(List<Drink> drinks) {
        this.drinks = drinks;
    }

    @Override
    public String toString() {
        return "Place{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", picture='" + picture + '\'' +
                ", drinks=" + drinks +
                '}';
    }
}
