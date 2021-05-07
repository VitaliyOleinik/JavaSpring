package com.entites;
import lombok.*;
import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table(name = "person")
@Data
@Getter
@Setter
@ToString
public class Person {
    // @GeneratedValue - указывает, что данное свойство будет создаваться согласно указанной стратегии.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", length = 200)
    private String name;

    @Column(name = "surname", length = 200)
    private String surname;

    @Column(name = "patronymic", length = 200)
    private String patronymic;

    @Column(name = "counter")
    private static int cnt = 0;

    @Column(name = "total_cost")
    private int totalCost;

    private static final ArrayList<MaterialValues> personMaterialValues = new ArrayList<>(10);
    private static int sizeOfMV = 0;

    public Person() {}

    public Person(Long id, String name, String surname, String patronymic, int totalCost) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
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
