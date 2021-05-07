package com.controllers;

import com.db.MaterialValueDAO;
import com.db.PersonDAO;
import com.entites.MaterialValues;
import com.entites.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProcessController {
    @RequestMapping(value = "/process", method = RequestMethod.GET)
    // RequestParam принимает данные из формы с полями name, surname, age
    public ModelAndView toProcess(@RequestParam(name = "name", defaultValue = "No Name")String name,
                                  @RequestParam(name = "surname", required = false, defaultValue = "No SurName") String surName,
                                  @RequestParam(name = "patronymic", required = false, defaultValue = "No Patronymic") String patronymic){
        //System.out.println("You entered: " + name + " " + surName + " " + age + "!");
        String text = name + " " + surName + " " + patronymic + "!";
        ModelAndView mw = new ModelAndView("process");

        mw.addObject("text", text);
        return mw;
    }
    @RequestMapping(value = "/adduser", method = RequestMethod.POST)
    public String addUser(@RequestParam(name = "name", defaultValue = "No Name")String name,
                          @RequestParam(name = "surname", required = false, defaultValue = "No SurName") String surName,
                          @RequestParam(name = "patronymic", required = false, defaultValue = "No Patronymic") String patronymic){
        PersonDAO.addPerson(new Person(null, name, surName, patronymic));

        return "redirect:/adduser";
    }
    @RequestMapping(value = "/addMaterialValue", method = RequestMethod.POST)
    public String addMaterialValue(@RequestParam(name = "name", defaultValue = "No Name")String name,
                          @RequestParam(name = "cost", defaultValue = "0") int cost
    //                               ,@RequestParam(name = "person") String person
                                   )
    {
        MaterialValueDAO.addMV(new MaterialValues(null, name, cost));


        return "redirect:/addMaterialValue";
    }
}
