package com.example.car.service;

import com.example.car.model.Country;

import java.util.List;

public interface ICountryService {
    List<Country> findAll();

    List<Country> getListCountry();
}
