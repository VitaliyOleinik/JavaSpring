package com.controllers;

import com.db.Books;
import com.db.DBManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@Controller
public class MainController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index(){
        return new ModelAndView("index");
    }

    @RequestMapping(value = "/all_books", method = RequestMethod.GET)
    public ModelAndView getAllBooks(){
        ArrayList<Books>allBooks = DBManager.getAllBooks();
        ModelAndView mw = new ModelAndView("all_books");
        mw.addObject("books", allBooks);
        return mw;
    }

}
