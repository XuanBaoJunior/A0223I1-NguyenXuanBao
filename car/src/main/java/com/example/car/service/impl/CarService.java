package com.example.car.service.impl;

import com.example.car.dto.CarDTO;
import com.example.car.model.Car;
import com.example.car.repository.ICarRepository;
import com.example.car.repository.impl.CarRepository;
import com.example.car.service.ICarService;

import java.util.List;

public class CarService implements ICarService {
    private ICarRepository iCarRepository = new CarRepository();
    @Override
    public List<Car> findAll() {
        return iCarRepository.findAll();
    }

    @Override
    public void save(CarDTO carDTO) {
        iCarRepository.save(carDTO);
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
        return iCarRepository.findAllDTO();
    }
}
