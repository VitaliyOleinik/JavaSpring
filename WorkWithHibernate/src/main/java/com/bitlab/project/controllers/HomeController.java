package com.bitlab.project.controllers;

import com.bitlab.project.beans.CountryBean;
import com.bitlab.project.entities.Cities;
import com.bitlab.project.entities.Countries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    CountryBean countryBean;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index(){

        ModelAndView mw = new ModelAndView("index");

        List<Countries> countries = countryBean.getCountries();
        mw.addObject("countries", countries);

        return mw;

    }

    @RequestMapping(value = "/addcountry", method = RequestMethod.POST)
    public String addCountry(@RequestParam(name = "name") String name){

        countryBean.addCountry(new Countries(name));
        return "redirect:/";

    }

    @RequestMapping(value = "/readcountry/{countryId}", method = RequestMethod.GET)
    public ModelAndView readCountry(@PathVariable(name = "countryId") Long id){

        Countries country = countryBean.getCountry(id);
        List<Cities> cities = countryBean.getCities(id);

        ModelAndView mw = new ModelAndView("readcountry");
        mw.addObject("country", country);
        mw.addObject("cities", cities);

        return mw;

    }

    @RequestMapping(value = "/addcity", method = RequestMethod.POST)
    public String addCity(@RequestParam(name = "name") String name,
                          @RequestParam(name = "country_id") Long countryId){

        Countries tmp = new Countries();
        tmp.setId(countryId);

        Cities cities = new Cities(name, tmp);

        countryBean.addCity(cities);

        return "redirect:/readcountry/"+countryId;

    }

}
