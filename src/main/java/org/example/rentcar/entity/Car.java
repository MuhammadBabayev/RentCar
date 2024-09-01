package org.example.rentcar.entity;

import org.example.rentcar.enums.CarOrder;
import org.example.rentcar.utility.core_entity.CoreEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@SuperBuilder
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Car extends CoreEntity {
    String brand;
    String model;
    String color;
    String engine;
    String gear;
    Integer year;
    Double price;
    String picture;
    @Enumerated(EnumType.STRING)
    CarOrder carOrder;

    @OneToMany(mappedBy = "car")
    @JsonIgnore
    List<Like> likes;

    @OneToMany(mappedBy = "car")
    @JsonIgnore
    List<Order> orders;

    @OneToMany(mappedBy = "car")
    @JsonIgnore
    List<Comment> comments;

}
