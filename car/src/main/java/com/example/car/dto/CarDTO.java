package com.example.car.dto;

public class CarDTO {
    private int id_car;
    private String name_car;
    private int year_of_manufacture;
    private double price;
    private String country_manufacture;

    public CarDTO() {
    }

    public CarDTO(int id_car, String name_car, int year_of_manufacture, double price, String country_manufacture) {
        this.id_car = id_car;
        this.name_car = name_car;
        this.year_of_manufacture = year_of_manufacture;
        this.price = price;
        this.country_manufacture = country_manufacture;
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

    public String getCountry_manufacture() {
        return country_manufacture;
    }

    public void setCountry_manufacture(String country_manufacture) {
        this.country_manufacture = country_manufacture;
    }
}
