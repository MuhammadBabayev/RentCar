package org.example.rentcar.mapper.car;

import org.example.rentcar.dto.car.CreateCarRequestDto;
import org.example.rentcar.entity.Car;
import org.example.rentcar.enums.CarOrder;

public class CarCreateMapper    {
    public static Car dtoToEntity(CreateCarRequestDto createCarRequest) {
        return Car.builder()
                .brand(createCarRequest.getBrand())
                .model(createCarRequest.getModel())
                .gear(createCarRequest.getGear())
                .color(createCarRequest.getColor())
                .engine(createCarRequest.getEngine())
                .year(createCarRequest.getYear())
                .carOrder(CarOrder.UNORDERED)
                .price(createCarRequest.getPrice())
                .picture(createCarRequest.getPicture())
                .build();
    }
}
