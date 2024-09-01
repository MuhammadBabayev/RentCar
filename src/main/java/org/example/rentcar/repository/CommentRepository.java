package org.example.rentcar.repository;

import org.example.rentcar.entity.Car;
import org.example.rentcar.entity.Comment;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    Optional<List<Comment>> findAllByStatus(String status);
    Optional<List<Comment>> findAllBycar(Car car);

    @Query("SELECT c FROM Comment c WHERE c.id = :id AND c.status = 'A'")
    Optional<Comment> findByIdAndStatus(@Param("id") Long id);

    @Query("SELECT c FROM Comment c WHERE c.car.id = :carId AND c.status = 'A'")
    List<Comment> findActiveCommentsByCarId(@Param("carId") Long carId);

    @Query("SELECT c FROM Comment c WHERE c.car.id = :carId AND c.user.id = :userId AND c.status = 'A'")
    Optional<List<Comment>> findAllByCarAndUser(Long carId, Long userId);

    @Modifying
    @Transactional
    @Query("UPDATE Comment c SET c.comment = :newComment WHERE c.car.id = :carId AND c.user.id = :userId")
    void updateCommentByCarAndUser(@Param("carId") Long carId, @Param("userId") Long userId, @Param("newComment") String newComment);


    @Query("SELECT c FROM Comment c WHERE c.user.id = :userId AND c.status='A'")
    List<Comment> findCommentsByUserId(@Param("userId") Long userId);

}
