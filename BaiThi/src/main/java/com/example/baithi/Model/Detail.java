package com.example.baithi.Model;

public class Detail {
    private int id_book;
    private int id_student;

    public Detail() {
    }

    public Detail(int id_book, int id_student) {
        this.id_book = id_book;
        this.id_student = id_student;
    }

    public int getId_book() {
        return id_book;
    }

    public void setId_book(int id_book) {
        this.id_book = id_book;
    }

    public int getId_student() {
        return id_student;
    }

    public void setId_student(int id_student) {
        this.id_student = id_student;
    }
}
