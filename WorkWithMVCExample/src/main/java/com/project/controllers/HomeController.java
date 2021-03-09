package com.project.controllers;

import com.project.db.Cars;
import com.project.db.DBConnection;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@Controller
public class HomeController {

    private DBConnection connection;

    public HomeController(){
        connection = new DBConnection();
        connection.connect();
    }

    @RequestMapping(value = {"/", "/index", "/home"}, method = RequestMethod.GET)
    public ModelAndView indexPage(){

        ArrayList<String> names = new ArrayList<String>();
        names.add("Arman");
        names.add("Ilyas");
        names.add("John");

        ModelAndView mw = new ModelAndView("index");
        mw.addObject("imena", names);

        ArrayList<Cars> cars = connection.getAllCars();
        mw.addObject("cars", cars);

        return mw;

    }

    @RequestMapping(value = "/about", method = RequestMethod.GET)
    public ModelAndView aboutPage(){

        System.out.println("ABOUT PAGE");
        return new ModelAndView("about");

    }

    @RequestMapping(value = "/addcar", method = RequestMethod.POST)
    public String addCar(@RequestParam(name = "name", defaultValue = "No Name") String name,
                         @RequestParam(name = "model") String model,
                         @RequestParam(name = "max_speed") int maxSpeed,
                         @RequestParam(name = "year") int year,
                         @RequestParam(name = "engine_volume") double engineVolume
                         ){

        connection.addCar(new Cars(null, name, model, maxSpeed, year, engineVolume));

        return "redirect:/";
    }

    @RequestMapping(value = "/loadcar/{carId}-{shortDesc}.html", method = RequestMethod.GET)
    public ModelAndView loadCarPage(
            @PathVariable(name = "carId", required = false) Long id,
            @PathVariable(name = "shortDesc") String shortDesc
    ){
        Cars car = connection.getCar(id);
        System.out.println(shortDesc);
        ModelAndView mw = new ModelAndView("loadcar");
        mw.addObject("mashina", car);

        return mw;
    }

}
