package org.example.rentcar.service;

import org.example.rentcar.dto.Order.CreateOrderDTO;
import org.example.rentcar.dto.Order.GetOrderInformationDTO;
import org.example.rentcar.entity.Car;
import org.example.rentcar.entity.Order;
import org.example.rentcar.entity.Users;
import org.example.rentcar.enums.CarOrder;
import org.example.rentcar.enums.ExceptionMessage;
import org.example.rentcar.exception.BalanceException;
import org.example.rentcar.mapper.order.OrderCreateMapper;
import org.example.rentcar.mapper.order.OrderGetMapper;
import org.example.rentcar.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    private final CarService carService;

    private final UserService userService;

    public Iterable<Order> findAll() {
        return orderRepository.findAll();
    }

    public List<GetOrderInformationDTO> findByUserId(Long id) {
        List<Order> orders = orderRepository.findAllByUserIdAndStatus(id,"A");
        List<GetOrderInformationDTO> getOrderInformationDTOS = orders.stream()
                .map(OrderGetMapper::entityToDto)
                .toList();
        return getOrderInformationDTOS;
    }

    public void create(Long userId, Long carId, CreateOrderDTO createOrderDTO) {
        Optional<Users> user = Optional.ofNullable(userService.getUserById(userId));
        Optional<Car> car = Optional.ofNullable(carService.getCarById(carId));
        Order order = OrderCreateMapper.dtoToEntity(createOrderDTO,car,user);
        Long day = ChronoUnit.DAYS.between(createOrderDTO.getStartTime(),createOrderDTO.getEndTime()) + 1;
        Double calculatedPrice = car.get().getPrice() * day;
        if (calculatedPrice > user.get().getBalance()) {
            throw new BalanceException(String.format(ExceptionMessage.METHOD_NOT_ALLOWED.getMessage()));
        }
        order.setOrderAmount(calculatedPrice);
        userService.updateUserBalance(userId, calculatedPrice);
        carService.updateCarOrder(carId, CarOrder.ORDERED);
        orderRepository.save(order);


    }
}
