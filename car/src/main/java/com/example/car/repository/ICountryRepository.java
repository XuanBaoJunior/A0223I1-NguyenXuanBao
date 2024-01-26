package com.example.car.repository;

import com.example.car.model.Country;

import java.util.List;

public interface ICountryRepository {
    List<Country> findAll();

    List<Country> getListCountry();
}
