package com.example.dringo.controller;


import com.example.dringo.entity.Place;
import com.example.dringo.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PlaceController{
    @Autowired
    PlaceService placeService;

    @PostMapping ("/places")
    public String createPlace(@RequestBody Place place){
        placeService.savePlace(place);
        return "the place created: " + place.getName();
    }

//    @GetMapping ("/places/{name}")
//    public List<Place> getPlaceByName(@PathVariable String name){
//        return placeService.getPlaceByName(name);
//    }

    @GetMapping ("/places/{id}")
    public Place getPlaceByName(@PathVariable Long id){
        return placeService.getPlace(id);
    }

    @GetMapping ("/places")
    public List<Place> getAllPlaces(){
        return placeService.getAllPlaces();
    }

    @PutMapping ("/places")
    public String updatePlace(@RequestBody Place place){
        placeService.savePlace(place);
        return "the place was updated " + place.toString();
    }

    @PostMapping(value = "{cartId}/api/drinks/{itemId}/add")
    public void addDrinkToPlace(@PathVariable final Long cartId,
                              @PathVariable final Long itemId){
        Place place = placeService.addDrinkToPlace(cartId, itemId);
        System.out.println(place.toString());
    }


    @DeleteMapping ("/places/{id}")
    public String deletePlace(@PathVariable Long id){
        placeService.deletePlace(id);
        return "the place was deleted< which id is: " + id;
    }
}
