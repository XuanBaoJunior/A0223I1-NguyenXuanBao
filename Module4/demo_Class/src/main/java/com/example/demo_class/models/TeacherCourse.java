package com.example.demo_class.models;

import jakarta.persistence.*;

@Entity(name = "TeacherCourse")
public class TeacherCourse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "Teacher")
    private Teacher teacher;

    @ManyToOne
    @JoinColumn(name = "ClassLH")
    private ClassLH ClassLH;

    public TeacherCourse() {
    }

    public TeacherCourse(Integer id, Teacher teacher, com.example.demo_class.models.ClassLH classLH) {
        this.id = id;
        this.teacher = teacher;
        ClassLH = classLH;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public com.example.demo_class.models.ClassLH getClassLH() {
        return ClassLH;
    }

    public void setClassLH(com.example.demo_class.models.ClassLH classLH) {
        ClassLH = classLH;
    }
}
