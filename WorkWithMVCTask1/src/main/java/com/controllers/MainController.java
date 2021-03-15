package com.controllers;

import com.db.Books;
import com.db.DBManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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

    @RequestMapping(value = "/search_books", method = RequestMethod.GET)
    public ModelAndView getBookByName(@RequestParam(name = "name")String name){
        ArrayList<Books>searchedBooks = DBManager.getBookByName(name);
        ModelAndView mw = new ModelAndView("search_books");
        mw.addObject("searchedBooks", searchedBooks);
        return null;
    }

    @RequestMapping(value = "/addbook", method = RequestMethod.POST)
    public String addBook(@RequestParam(name = "name", defaultValue = "No Name")String name,
                                @RequestParam(name = "author", defaultValue = "No Name")String author,
                                @RequestParam(name = "price", defaultValue = "No Name")int price){
        DBManager.addBook(new Books(null, name, author, price));
        return "redirect:/";
    }
}
