package org.example.rentcar.dto.Order;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GetOrderInformationDTO {
    LocalDate startTime;

    LocalDate endTime;

    Double orderAmount;

    String carName;
}
