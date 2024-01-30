package com.example.crud.controller;

import com.example.crud.entities.CarEntity;
import com.example.crud.repository.CarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/cars")
public class CarController {

    @Autowired
    private CarRepo carRepo;

    @PostMapping("/createCar")
    public CarEntity createCar(@RequestBody CarEntity car) {
        CarEntity car1 = carRepo.saveAndFlush(car);
        return car1;
    }

    @GetMapping("/getAll")
    public List<CarEntity> carList() {
        List<CarEntity> carsList = carRepo.findAll();
        return carsList;
    }

    @GetMapping("/getCar/{id}")
    public Optional<CarEntity> getCarById(@PathVariable Long id) {
        Optional<CarEntity> optionalCar = carRepo.findById(id);
        return carRepo.findById(id);
    }

    @PatchMapping("/updateType/{id}")
    public CarEntity updateTypeCar(@PathVariable long id, @RequestBody CarEntity updatedCar) {
        Optional<CarEntity> optionalCar = carRepo.findById(id);

        if (optionalCar.isPresent()) {
            CarEntity existingCar = optionalCar.get();

            if (updatedCar.getType() != null) {
                existingCar.setType(updatedCar.getType());
            }

            return carRepo.saveAndFlush(existingCar);
        }
        return null;
    }


    @DeleteMapping("/deleteCar/{id}")
    public void deleteCar(@PathVariable Long id) {
        if (carRepo.existsById(id)) {
            carRepo.deleteById(id);
        }
    }

    @DeleteMapping("/deleteAll")
    public void deleteAllCars() {
        carRepo.deleteAll();
    }
}