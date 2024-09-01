package org.example.rentcar.repository;

import org.example.rentcar.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, Long> {
    Optional<Users> findByUserNameAndStatus(String userName, String status);
    Optional<List<Users>> findAllByStatus(String status);
    Optional<Users> findByIdAndStatus(Long id, String status);

    Users findByUserName(String userName);
}
