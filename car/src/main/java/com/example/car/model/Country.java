package com.example.car.model;

public class Country {
    private int id_country;
    private String country_manufacture;

    public Country() {
    }

    public Country(int id_country, String country_manufacture) {
        this.id_country = id_country;
        this.country_manufacture = country_manufacture;
    }

    public int getId_country() {
        return id_country;
    }

    public void setId_country(int id_country) {
        this.id_country = id_country;
    }

    public String getCountry_manufacture() {
        return country_manufacture;
    }

    public void setCountry_manufacture(String country_manufacture) {
        this.country_manufacture = country_manufacture;
    }
}
