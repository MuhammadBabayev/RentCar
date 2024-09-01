package org.example.rentcar.repository;

import org.example.rentcar.entity.Car;
import org.example.rentcar.entity.Like;
import org.example.rentcar.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LikeRepository extends JpaRepository<Like, Long> {
    
    Optional<Like> findByCarAndUser(Car car, Users user);

    void delete(Like like);
}
