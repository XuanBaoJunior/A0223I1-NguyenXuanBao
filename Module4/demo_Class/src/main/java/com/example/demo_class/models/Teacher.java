package com.example.demo_class.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.HashSet;
import java.util.Set;

@Entity(name = "Teacher")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTeacher", columnDefinition = "INT")
    private Integer idTeacher;
    @Column(name = "nameTeacher", columnDefinition = "VARCHAR(100)")
    @NotBlank(message = "Tên không được để trống")
    private String nameTeacher;
    @Column(name = "phoneNumber", columnDefinition = "VARCHAR(12)")
    @NotBlank(message = "SDT không được để trống")
    private String phoneNumber;

    @ManyToMany
    @JoinTable(name = "ClassLH",
            joinColumns = @JoinColumn(name = "idClass"),
            inverseJoinColumns = @JoinColumn(name = "idTeacher"))
    private Set<ClassLH> classes;

    public Teacher() {
    }

    public Teacher(Integer idTeacher, String nameTeacher, String phoneNumber, Set<ClassLH> classes) {
        this.idTeacher = idTeacher;
        this.nameTeacher = nameTeacher;
        this.phoneNumber = phoneNumber;
        this.classes = classes;
    }

    public Integer getIdTeacher() {
        return idTeacher;
    }

    public void setIdTeacher(Integer idTeacher) {
        this.idTeacher = idTeacher;
    }

    public String getNameTeacher() {
        return nameTeacher;
    }

    public void setNameTeacher(String nameTeacher) {
        this.nameTeacher = nameTeacher;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Set<ClassLH> getClasses() {
        return classes;
    }

    public void setClasses(Set<ClassLH> classes) {
        this.classes = classes;
    }
}
