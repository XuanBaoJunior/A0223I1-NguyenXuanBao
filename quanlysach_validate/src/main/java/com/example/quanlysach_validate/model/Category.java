package com.example.quanlysach_validate.model;

public class Category {
    private int id_category;
    private String type;

    public Category() {
    }

    public Category(int id_category, String type) {
        this.id_category = id_category;
        this.type = type;
    }

    public Category(int id_category) {
        this.id_category = id_category;
    }

    public int getId_category() {
        return id_category;
    }

    public void setId_category(int id_category) {
        this.id_category = id_category;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
