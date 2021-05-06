package com.controllers;

import com.db.DBManager;
import com.entites.MaterialValues;
import com.entites.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@Controller
public class MainController {
    // to Get
    @RequestMapping(value = "/", method = RequestMethod.GET)
    // если обращаемся к этой ссылке, то запускатся этот метод
    public ModelAndView indexPage(){
//        ArrayList<User>allUsers = DBManager.getAllusers();
        ArrayList<Person>allPersons = DBManager.getAllPersons();
        // путь к jsp
        ModelAndView mw = new ModelAndView("index");
        mw.addObject("users", allPersons);
        return mw;
    }

    @RequestMapping(value = "addMaterialValue", method = RequestMethod.GET)
    public ModelAndView addMaterialValuePage(){
        ArrayList<MaterialValues>allMV = DBManager.getAllMaterialValues();
        ModelAndView mw = new ModelAndView("addMaterialValue");
        mw.addObject("materialValues", allMV);
        return mw;
    }

    @RequestMapping(value = "about", method = RequestMethod.GET)
    public ModelAndView aboutPage(){
        ModelAndView mw = new ModelAndView("aboutPage");
        return mw;
    }

    @RequestMapping(value = "adduser", method = RequestMethod.GET)
    public ModelAndView addUserPage(){
        ModelAndView mw = new ModelAndView("adduser");
        return mw;
    }

    @RequestMapping(value = "/readmore/{userId}", method = RequestMethod.GET)
    public ModelAndView readMore(@PathVariable(name = "userId") Long id){
        Person person = DBManager.getPersonById(id);
        ModelAndView mw = new ModelAndView("readMore");
        mw.addObject("person", person);
        return mw;
    }
}
