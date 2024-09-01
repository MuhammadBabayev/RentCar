package org.example.rentcar.service;

import org.example.rentcar.dto.car.CarUpdateRequestDto;
import org.example.rentcar.dto.car.CreateCarRequestDto;
import org.example.rentcar.entity.Car;
import org.example.rentcar.enums.CarOrder;
import org.example.rentcar.exception.NotFoundException;
import org.example.rentcar.mapper.car.CarCreateMapper;
import org.example.rentcar.mapper.car.CarUpdateMapper;
import org.example.rentcar.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CarService {
    private final CarRepository carRepository;

    public Optional<List<Car>> getAllCars() {
        return carRepository.findAllUnordered();
    }


    public Car createCar(CreateCarRequestDto createCarRequest) {
        Car car = CarCreateMapper.dtoToEntity(createCarRequest);
        return carRepository.save(car);

    }

    public Car
    getCarById(Long id) {
        return carRepository.findByIdAndStatus(id,"A").orElseThrow(
                ()-> new NotFoundException(
                        String.format("Car with id %s not found", id)
                )
        );

    }

    public void updateCarOrder(Long carId,CarOrder carOrder) {
        Optional<Car> car = carRepository.findByIdAndStatus(carId,"A");
        if (car.isPresent()) {
            car.get().setCarOrder(carOrder);
            carRepository.save(car.get());
        }
    }


    public Car updateCar(Long carId, CarUpdateRequestDto carUpdateRequest) {
        Optional<Car> carOptional = carRepository.findByIdAndStatus(carId, "A");

        if (carOptional.isPresent()) {
            Car car = carOptional.get();
            CarUpdateMapper.dtoToEntity(carUpdateRequest, car);

            return carRepository.save(car);
        }

        return null;
    }

    public void deleteCarById(Long carId) {
        Car car = carRepository.findByIdAndStatus(carId,"A").orElse(null);
        car.setStatus("D");
        carRepository.save(car);
    }

}
