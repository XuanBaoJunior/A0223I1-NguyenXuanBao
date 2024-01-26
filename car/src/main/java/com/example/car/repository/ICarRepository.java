package com.example.car.repository;

import com.example.car.dto.CarDTO;
import com.example.car.model.Car;

import java.util.List;

public interface ICarRepository {
    List<Car> findAll();

    void save(CarDTO carDTO);

    Car findById(Integer idCar);

    void update (Car carUpdate);

    void deleteById(Integer idDelete);

    List<CarDTO> findAllDTO();
}
