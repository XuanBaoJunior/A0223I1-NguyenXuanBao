package com.example.baithi.Model;

public class Student {
    private int id_student;
    private String name_student;
    private String class_student;

    public Student() {
    }

    public Student(int id_student, String name_student, String class_student) {
        this.id_student = id_student;
        this.name_student = name_student;
        this.class_student = class_student;
    }

    public Student(String name_student, String class_student) {
        this.name_student = name_student;
        this.class_student = class_student;
    }

    public int getId_student() {
        return id_student;
    }

    public void setId_student(int id_student) {
        this.id_student = id_student;
    }

    public String getName_student() {
        return name_student;
    }

    public void setName_student(String name_student) {
        this.name_student = name_student;
    }

    public String getClass_student() {
        return class_student;
    }

    public void setClass_student(String class_student) {
        this.class_student = class_student;
    }
}
