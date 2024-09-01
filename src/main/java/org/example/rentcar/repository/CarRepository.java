package org.example.rentcar.repository;

import org.example.rentcar.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CarRepository extends JpaRepository<Car, Long> {
    Optional<Car> findByIdAndStatus(Long id, String status);

    @Query(value = """
            select a from Car a where a.carOrder = 'UNORDERED' order by random()
                    """)
    Optional<List<Car>> findAllUnordered();
    List<Car> findAllCarByStatus(String status);
}
