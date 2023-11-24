package com.example.quan_ly_sach.model;

public class Product {
    private int id;
    private String name;
    private double price;
    private String author;
    private String describeBook;

    public Product() {
    }

    public Product(String name, double price, String author, String describeBook) {
        this.name = name;
        this.price = price;
        this.author = author;
        this.describeBook = describeBook;
    }

    public Product(int id, String name, double price, String author, String describeBook) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.author = author;
        this.describeBook = describeBook;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescribeBook() {
        return describeBook;
    }

    public void setDescribeBook(String describeBook) {
        this.describeBook = describeBook;
    }
}
