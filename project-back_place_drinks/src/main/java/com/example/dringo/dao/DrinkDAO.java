package com.example.dringo.dao;

import com.example.dringo.entity.Drink;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DrinkDAO extends JpaRepository<Drink, Long> {
    List<Drink> findAllByName(String name);
}
