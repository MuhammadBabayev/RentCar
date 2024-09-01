package org.example.rentcar.dto.car;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CarUpdateRequestDto {
    String color;
    String engine;
    String gear;
    Double price;
    String picture;
}
