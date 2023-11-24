package com.example.demo_category.Model;

public class Category {
    private int id_category;
    private String type_category;

    public Category() {
    }

    public Category(int id_category) {
        this.id_category = id_category;
    }

    public Category(int id_category, String type_category) {
        this.id_category = id_category;
        this.type_category = type_category;
    }

    public int getId_category() {
        return id_category;
    }

    public void setId_category(int id_category) {
        this.id_category = id_category;
    }

    public String getType_category() {
        return type_category;
    }

    public void setType_category(String type_category) {
        this.type_category = type_category;
    }
}
