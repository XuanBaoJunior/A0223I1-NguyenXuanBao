package com.example.demo_category.Model;

public class Product {
    private int id_product;
    private String name_product;
    private String color_product;
    private String describe_product;
    private Category category;

    public Product() {
    }

    public Product(int id_product, String name_product, String color_product, String describe_product, Category category) {
        this.id_product = id_product;
        this.name_product = name_product;
        this.color_product = color_product;
        this.describe_product = describe_product;
        this.category = category;
    }

    public Product(String name_product, String color_product, String describe_product, Category category) {
        this.name_product = name_product;
        this.color_product = color_product;
        this.describe_product = describe_product;
        this.category = category;
    }

    public Product(int id_product, String name_product, String color_product, String describe_product) {
        this.id_product = id_product;
        this.name_product = name_product;
        this.color_product = color_product;
        this.describe_product = describe_product;
    }

    public int getId_product() {
        return id_product;
    }

    public void setId_product(int id_product) {
        this.id_product = id_product;
    }

    public String getName_product() {
        return name_product;
    }

    public void setName_product(String name_product) {
        this.name_product = name_product;
    }

    public String getColor_product() {
        return color_product;
    }

    public void setColor_product(String color_product) {
        this.color_product = color_product;
    }

    public String getDescribe_product() {
        return describe_product;
    }

    public void setDescribe_product(String describe_product) {
        this.describe_product = describe_product;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
