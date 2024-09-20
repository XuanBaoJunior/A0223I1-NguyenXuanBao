package com.example.demo_class.models;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity(name = "ClassLH")
public class ClassLH {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idClass", columnDefinition = "INT")
    private Integer idClass;
    @Column(name = "nameClass", columnDefinition = "VARCHAR(100)")

    private String nameClass;

    @ManyToMany
    @JoinTable(name = "Teacher",
            joinColumns = @JoinColumn(name = "idTeacher"),
            inverseJoinColumns = @JoinColumn(name = "idClass"))
    private Set<Teacher> teacher;

    public ClassLH() {
    }

    public ClassLH(Integer idClass, String nameClass, Set<Teacher> teacher) {
        this.idClass = idClass;
        this.nameClass = nameClass;
        this.teacher = teacher;
    }

    public Integer getIdClass() {
        return idClass;
    }

    public void setIdClass(Integer idClass) {
        this.idClass = idClass;
    }

    public String getNameClass() {
        return nameClass;
    }

    public void setNameClass(String nameClass) {
        this.nameClass = nameClass;
    }

    public Set<Teacher> getTeacher() {
        return teacher;
    }

    public void setTeacher(Set<Teacher> teacher) {
        this.teacher = teacher;
    }
}
