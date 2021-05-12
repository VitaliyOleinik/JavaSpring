package com.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.entities.Cars;
import com.db.CarsDAO;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    CarsDAO carsDAO;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index(){

        List<Cars> cars = carsDAO.getAllCars();
        ModelAndView mw = new ModelAndView("index");
        mw.addObject("cars", cars);
        return mw;
    }

    @RequestMapping(value = "/addcar", method = RequestMethod.POST)
    public String addCar(@RequestParam(name = "name") String name,
                         @RequestParam(name = "model") String model,
                         @RequestParam(name = "price") int price,
                         @RequestParam(name = "year") int year){

        Cars car = new Cars(name, model, year, price);
        carsDAO.addCar(car);

        return "redirect:/";
    }
}
