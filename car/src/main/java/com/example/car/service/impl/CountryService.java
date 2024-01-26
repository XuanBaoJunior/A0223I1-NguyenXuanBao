package com.example.car.service.impl;

import com.example.car.model.Country;
import com.example.car.repository.ICarRepository;
import com.example.car.repository.ICountryRepository;
import com.example.car.repository.impl.CountryRepository;
import com.example.car.service.ICountryService;

import java.util.List;

public class CountryService implements ICountryService {
    private ICountryRepository iCountryRepository = new CountryRepository();
    @Override
    public List<Country> findAll() {
        return iCountryRepository.findAll();
    }

    @Override
    public List<Country> getListCountry() {
        return iCountryRepository.getListCountry();
    }
}
