package com.example.dringo.service;



import com.example.dringo.entity.Drink;
import com.example.dringo.entity.Place;

import java.util.List;
import java.util.concurrent.ExecutionException;

public interface PlaceService {
    public void savePlace(Place place);

    public List<Place> getPlaceByName(String name);

    public List<Place> getAllPlaces();

    public Place getPlace(Long id);

    public void deletePlace(Long id);

    public Place addDrinkToPlace(Long placeId, Long drinkId);

    public Place removeDrinkFromPlace(Long placeId, Long drinkId);
}
