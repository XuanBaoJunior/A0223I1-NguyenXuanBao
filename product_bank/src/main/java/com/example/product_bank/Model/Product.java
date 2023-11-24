package com.example.product_bank.Model;

public class Product {
    private int id_product;
    private String name;
    private int number;
    private String mota;
    private Bank bank;

    public Product(int id_product, String name, int number, String mota, Bank bank) {
        this.id_product = id_product;
        this.name = name;
        this.number = number;
        this.mota = mota;
        this.bank = bank;
    }

    public Product(int id_product, String name, int number, String mota) {
        this.id_product = id_product;
        this.name = name;
        this.number = number;
        this.mota = mota;
    }

    public Product(String name, int number, String mota, Bank bank) {
        this.name = name;
        this.number = number;
        this.mota = mota;
        this.bank = bank;
    }

    public int getId_product() {
        return id_product;
    }

    public void setId_product(int id_product) {
        this.id_product = id_product;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }
}
