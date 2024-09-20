package com.example.ss8demo.models;

import jakarta.persistence.*;

@Entity(name = "classrooms")
public class Classroom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codeClass;

    private String nameClass;

    public Classroom() {
    }

    public Integer getCodeClass() {
        return codeClass;
    }

    public void setCodeClass(Integer codeClass) {
        this.codeClass = codeClass;
    }

    public String getNameClass() {
        return nameClass;
    }

    public void setNameClass(String nameClass) {
        this.nameClass = nameClass;
    }
}
