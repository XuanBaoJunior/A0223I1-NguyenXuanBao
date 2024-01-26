package com.example.car.service;

import com.example.car.dto.CarDTO;
import com.example.car.model.Car;

import java.util.List;

public interface ICarService {
    List<Car> findAll();

    void save(CarDTO carDTO);

    Car findById(Integer idCar);

    void update (Car carUpdate);

    void deleteById(Integer idDelete);

    List<CarDTO> findAllDTO();
}
