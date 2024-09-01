package org.example.rentcar.repository;

import org.example.rentcar.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findAllByUserIdAndStatus(Long ida, String status);
}
