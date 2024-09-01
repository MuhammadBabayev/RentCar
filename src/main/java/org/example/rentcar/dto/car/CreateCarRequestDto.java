package org.example.rentcar.dto.car;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateCarRequestDto {
    String brand;
    String model;
    String color;
    String engine;
    String gear;
    Integer year;
    Double price;
    String picture;
}
