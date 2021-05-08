package com.bitlab.project.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "countries")
public class Countries implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", length = 200)
    private String name;

    public Countries(String name) {
        this.name = name;
    }

    public Countries(){

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
}
