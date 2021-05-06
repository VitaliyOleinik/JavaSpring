package com.db;

import com.entites.MaterialValues;
import com.entites.Person;

import java.util.ArrayList;

public class DBManager {
    private static ArrayList<Person>allPersons = new ArrayList<>();
    private static ArrayList<MaterialValues>allMaterialValues = new ArrayList<>();
    private static Person person;

    private static Long idForPerson = 1L;
    private static Long idForMV = 1L;
    private Long counter = 1L;

    public static void addPerson(Person p){
        p.setId(idForPerson);
        allPersons.add(p);
        idForPerson++;
    }

//    public static void addMaterialValue (MaterialValues v){
//        v.setId(idForMV);
//        person.personMaterialValues.add(v);
//        person.idForMV++;
//    }

    public static ArrayList<Person>getAllPersons() { return allPersons; }
    public static ArrayList<MaterialValues>getAllMaterialValues() { return allMaterialValues; }

    public static Person getPersonById(Long id){
        for(Person p: allPersons){
            if(p.getId().equals(id)){
                return p;
            }
        }
        return null;
    }

    public static MaterialValues getMaterialValuesById(Long id){
        for(MaterialValues mv: allMaterialValues){
            if(mv.getId().equals(id)){
                return mv;
            }
        }
        return null;
    }
}
