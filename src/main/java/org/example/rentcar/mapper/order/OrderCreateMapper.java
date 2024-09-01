package org.example.rentcar.mapper.order;

import org.example.rentcar.dto.Order.CreateOrderDTO;
import org.example.rentcar.entity.Car;
import org.example.rentcar.entity.Order;
import org.example.rentcar.entity.Users;
import org.example.rentcar.utility.QDate;

import java.time.LocalDateTime;
import java.util.Optional;


public class OrderCreateMapper {
    public static Order dtoToEntity(CreateOrderDTO createOrderDTO, Optional<Car> car, Optional<Users> users){
        LocalDateTime startTime = QDate.startDateToLocalDateTime(createOrderDTO.getStartTime());
        LocalDateTime endTime = QDate.endDateToLocalDateTime(createOrderDTO.getEndTime());
        return Order.builder()
                .car(car.get())
                .user(users.get())
                .startTime(startTime)
                .endTime(endTime)
                .build();
    }
}
