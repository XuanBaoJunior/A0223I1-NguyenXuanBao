package com.example.car.model;

public class Car {
    private int id_car;
    private String name_car;
    private int year_of_manufacture;
    private double price;

    public Car() {
    }

    public Car(int id_car, String name_car, int year_of_manufacture, double price) {
        this.id_car = id_car;
        this.name_car = name_car;
        this.year_of_manufacture = year_of_manufacture;
        this.price = price;
    }

    public int getId_car() {
        return id_car;
    }

    public void setId_car(int id_car) {
        this.id_car = id_car;
    }

    public String getName_car() {
        return name_car;
    }

    public void setName_car(String name_car) {
        this.name_car = name_car;
    }

    public int getYear_of_manufacture() {
        return year_of_manufacture;
    }

    public void setYear_of_manufacture(int year_of_manufacture) {
        this.year_of_manufacture = year_of_manufacture;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
