package com.example.car.repository.impl;

import com.example.car.model.Country;
import com.example.car.repository.BaseRepository;
import com.example.car.repository.ICountryRepository;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CountryRepository implements ICountryRepository {
    @Override
    public List<Country> findAll() {
        List<Country> countrys = new ArrayList<>();
        Country country;
        try {
            Statement statement = BaseRepository.getConnectionJavaToDB().createStatement();
            ResultSet resultSet = statement.executeQuery("select id_country, country_manufacture from country");
            while (resultSet.next()){
                country = new Country();
                country.setId_country(resultSet.getInt("id_country"));
                country.setCountry_manufacture(resultSet.getString("country_manufacture"));

                countrys.add(country);
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return countrys;
    }

    @Override
    public List<Country> getListCountry() {
        List<Country> countryList=new ArrayList<>();
        String findCountryListSQL;
        Country country;
        Integer id_country=0;
        findCountryListSQL= "select country_manufacture from country union select country_manufacture from country;";
        try {
            CallableStatement callableStatement= BaseRepository.getConnectionJavaToDB().prepareCall(findCountryListSQL);
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()){
                country = new Country();
                id_country++;
                country.setId_country(id_country);
                country.setCountry_manufacture(resultSet.getString("country_manufacture"));
                countryList.add(country);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return countryList;
    }
}
