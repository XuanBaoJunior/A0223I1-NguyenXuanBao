package com.example.baithi.Model;

public class Book {
    private int id_book;
    private String name_book;
    private String author;
    private String quatity;
    private String description;

    public Book() {
    }

    public Book(int id_book, String name_book, String author, String quatity, String description) {
        this.id_book = id_book;
        this.name_book = name_book;
        this.author = author;
        this.quatity = quatity;
        this.description = description;
    }

    public Book(String name_book, String author, String quatity, String description) {
        this.name_book = name_book;
        this.author = author;
        this.quatity = quatity;
        this.description = description;
    }

    public int getId_book() {
        return id_book;
    }

    public void setId_book(int id_book) {
        this.id_book = id_book;
    }

    public String getName_book() {
        return name_book;
    }

    public void setName_book(String name_book) {
        this.name_book = name_book;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getQuatity() {
        return quatity;
    }

    public void setQuatity(String quatity) {
        this.quatity = quatity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
