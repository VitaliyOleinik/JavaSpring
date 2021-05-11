package com.controllers;

import com.beans.OtherBean;
import com.beans.TestBean;
import com.db.DBManager;
import com.db.DBManagerPhpMyAdmin;
import com.db.User;
import com.entites.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@Controller
public class MainController {

    @Autowired
    private TestBean testBean;

    @Autowired
    private OtherBean myOtherBean;

    @Autowired
    private OtherBean mySecondBean;

    @Autowired
    private DBManagerPhpMyAdmin dbManagerPhpMyAdmin; // BeanConfig.java

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView indexPage(){
        //ArrayList<User>allusers = DBManager.getAllusers();

//        mw.addObject("message", testBean.getData());
//        mw.addObject("secondMessage", myOtherBean.getData());
//        mw.addObject("mySecondBean", mySecondBean.getData());

        ArrayList<Users>allusers = dbManagerPhpMyAdmin.getAllUsers();

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
        Users user = dbManagerPhpMyAdmin.getUserById(id);
        ModelAndView mw = new ModelAndView("readMore");
        mw.addObject("user", user);
        return mw;
    }
}
