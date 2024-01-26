package com.example.car.repository.impl;

import com.example.car.dto.CarDTO;
import com.example.car.model.Car;
import com.example.car.repository.BaseRepository;
import com.example.car.repository.ICarRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CarRepository implements ICarRepository {
    @Override
    public List<Car> findAll() {
        return null;
    }

    @Override
    public void save(CarDTO carDTO) {
        try {
            PreparedStatement preparedStatement = BaseRepository.getConnectionJavaToDB().
                    prepareStatement("INSERT INTO car (id_car, name_car, year_of_manufacture, price) values (?,?,?,?)");
            preparedStatement.setInt(1, carDTO.getId_car());
            preparedStatement.setString(2, carDTO.getName_car());
            preparedStatement.setInt(3, carDTO.getYear_of_manufacture());
            preparedStatement.setDouble(4, carDTO.getPrice());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Car findById(Integer idCar) {
        return null;
    }

    @Override
    public void update(Car carUpdate) {

    }

    @Override
    public void deleteById(Integer idDelete) {

    }

    @Override
    public List<CarDTO> findAllDTO() {
        List<CarDTO> carDTOs = new ArrayList<>();
        CarDTO carDTO;
//        Statement statement = null;
        try {
            Statement statement = BaseRepository.getConnectionJavaToDB().createStatement();
            ResultSet resultSet = statement.executeQuery("select car.id_car, name_car, year_of_manufacture, price, country_manufacture from car join country on car.id_car = country.id_car");
            while (resultSet.next()){
                carDTO = new CarDTO();
                carDTO.setId_car(resultSet.getInt("id_car"));
                carDTO.setName_car(resultSet.getString("name_car"));
                carDTO.setYear_of_manufacture(resultSet.getInt("year_of_manufacture"));
                carDTO.setPrice(resultSet.getDouble("price"));
                carDTO.setCountry_manufacture(resultSet.getString("country_manufacture"));
                carDTOs.add(carDTO);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return carDTOs;
    }
}
