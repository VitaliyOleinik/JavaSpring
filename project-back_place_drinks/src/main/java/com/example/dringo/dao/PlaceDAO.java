package com.example.dringo.dao;

import com.example.dringo.entity.Drink;
import com.example.dringo.entity.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PlaceDAO extends JpaRepository<Place, Long> {
    List<Place> findAllByName(String name);
}
