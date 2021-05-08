package com.bitlab.project.beans;

import com.bitlab.project.entities.Cities;
import com.bitlab.project.entities.Countries;

import java.util.List;

public interface CountryBean {

    void addCountry(Countries country);
    void deleteCountry(Long id);
    Countries getCountry(Long id);
    void saveCountry(Countries country);
    List<Countries> getCountries();

    void addCity(Cities city);
    List<Cities> getCities(Long id);

}
