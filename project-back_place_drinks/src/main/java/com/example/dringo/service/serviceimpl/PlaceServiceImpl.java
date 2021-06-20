package com.example.dringo.service.serviceimpl;

import com.example.dringo.dao.DrinkDAO;
import com.example.dringo.dao.PlaceDAO;
import com.example.dringo.entity.Drink;
import com.example.dringo.entity.Place;
import com.example.dringo.service.DrinkService;
import com.example.dringo.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
@Service
@Transactional
public class PlaceServiceImpl implements PlaceService {

    @Autowired
    private PlaceDAO placeDAO;
    @Autowired
    private DrinkService drinkService;

    @Override
    public void savePlace(Place place){
        placeDAO.save(place);
    }

    @Override
    public List<Place> getPlaceByName(String name){
        return placeDAO.findAllByName(name);
    }

    @Override
    public List<Place> getAllPlaces(){
        return placeDAO.findAll();
    }

    @Override
    public Place getPlace(Long id) {
        Place place = null;
        Optional<Place>optional = placeDAO.findById(id);
        place = optional.orElse(null);
        return place;
    }

    @Override
    public void deletePlace(Long id){
        placeDAO.deleteById(id);
    }

    @Override
    public Place addDrinkToPlace(Long placeId, Long drinkId) {
        Place place = getPlace(placeId);
        Drink drink = drinkService.getDrink(drinkId);
        place.addDrinkToPlace(drink);
        return place;
    }

    @Override
    public Place removeDrinkFromPlace(Long placeId, Long drinkId) {
        Place place = getPlace(placeId);
        Drink drink = drinkService.getDrink(drinkId);
        place.removeDrinkFromPlace(drink);
        return place;
    }
}
