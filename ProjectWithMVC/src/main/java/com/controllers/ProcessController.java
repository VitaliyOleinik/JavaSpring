package com.controllers;

import com.db.DBManager;
import com.db.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProcessController {
    @RequestMapping(value = "/process", method = RequestMethod.GET)
    public ModelAndView toProcess(@RequestParam(name = "name", defaultValue = "No Name")String name,
                                    @RequestParam(name = "surname", required = false, defaultValue = "No SurName") String surName,
                                    @RequestParam(name = "age", required = false, defaultValue = "0") int age){
        //System.out.println("You entered: " + name + " " + surName + " " + age + "!");
        String text = "You entered: " + name + " " + surName + " " + age + "!";
        ModelAndView mw = new ModelAndView("process");

        mw.addObject("text", text);
        return mw;
    }
    @RequestMapping(value = "/adduser", method = RequestMethod.POST)
    public String addUser(@RequestParam(name = "name", defaultValue = "No Name")String name,
                          @RequestParam(name = "surname", required = false, defaultValue = "No SurName") String surName,
                          @RequestParam(name = "age", required = false, defaultValue = "0") int age){
        DBManager.addUser(new User(null, name, surName, age));
        return "redirect:/";
    }
}
