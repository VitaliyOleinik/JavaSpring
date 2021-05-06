package com.entites;

import java.util.ArrayList;

public class Person {
    private Long id;
    private String name;
    private String surname;
    private String patronymic;
    private static int cnt = 0;
    private int totalCost;
    private static final ArrayList<MaterialValues> personMaterialValues = new ArrayList<>(10);
    private static int sizeOfMV = 0;

    public Person(Long id, String name, String surname, String patronymic, int cnt, int totalCost) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        Person.cnt = cnt;
        this.totalCost = totalCost;
    }

    public Person(Long id, String name, String surname, String patronymic){
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public int getCnt() {
        return cnt;
    }

    public static void setCnt(int cnt) {
        Person.cnt = cnt;
    }

    public int getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(int totalCost) {
        this.totalCost = totalCost;
    }

    public static void addMaterialValues(MaterialValues value){
        if(sizeOfMV < personMaterialValues.size()){
            personMaterialValues.add(value);
            sizeOfMV++;
            cnt++;
            setCnt(Person.cnt);
        }
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", cnt=" + cnt +
                ", totalCost=" + totalCost +
                '}';
    }
}
