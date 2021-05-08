package com.bitlab.project.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "cities")
public class Cities implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", length = 200)
    private String name;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Countries country;

    public Cities(String name, Countries country) {
        this.name = name;
        this.country = country;
    }

    public Cities(){

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

    public Countries getCountry() {
        return country;
    }

    public void setCountry(Countries country) {
        this.country = country;
    }
}
