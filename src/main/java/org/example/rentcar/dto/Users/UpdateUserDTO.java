package org.example.rentcar.dto.Users;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UpdateUserDTO {
    String username;
    String name;
    String email;
    String phone;
    String licence;
    Double balance;
}
