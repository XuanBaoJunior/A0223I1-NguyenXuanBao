package com.example.product_bank.Model;

public class Bank {
    private int id;
    private String namebank;

    public Bank(int id) {
        this.id = id;
    }

    public Bank(int id, String namebank) {
        this.id = id;
        this.namebank = namebank;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNamebank() {
        return namebank;
    }

    public void setNamebank(String namebank) {
        this.namebank = namebank;
    }
//    public Bank(int id, String name) {
//        this.id = id;
//        this.namebank = namebank;
//    }
//
//    public Bank(int id) {
//        this.id = id;
//    }
//
//    public Bank() {
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
}
