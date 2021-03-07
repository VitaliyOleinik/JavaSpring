package com.controllers;

import com.db.DBManager;
import com.db.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@Controller
public class MainController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView indexPage(){
        ArrayList<User>allusers = DBManager.getAllusers();
        ModelAndView mw = new ModelAndView("index");
        mw.addObject("users", allusers);
        return mw;
    }

    @RequestMapping(value = "about", method = RequestMethod.GET)
    public ModelAndView aboutPage(){
        ModelAndView mw = new ModelAndView("aboutPage");
        return mw;
    }

    @RequestMapping(value = "/readmore/{userId}", method = RequestMethod.GET)
    public ModelAndView readMore(@PathVariable(name = "userId") Long id){
        User user = DBManager.getuserById(id);
        ModelAndView mw = new ModelAndView("readMore");
        mw.addObject("user", user);
        return mw;
    }
}
