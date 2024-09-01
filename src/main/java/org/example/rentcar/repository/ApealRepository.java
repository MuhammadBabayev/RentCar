package org.example.rentcar.repository;

import org.example.rentcar.entity.Apeal;
import org.example.rentcar.enums.ApealProgress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApealRepository extends JpaRepository<Apeal, Long> {
    Iterable<Object> findByApealProgress(ApealProgress apealProgress);
}
