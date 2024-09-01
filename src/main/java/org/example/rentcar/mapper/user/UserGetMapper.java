package org.example.rentcar.mapper.user;

import org.example.rentcar.dto.Users.GetUserDTO;
import org.example.rentcar.entity.Users;

public class UserGetMapper {
    public static GetUserDTO entityToDto(Users user) {
        return GetUserDTO.builder()
                .balance(user.getBalance())
                .name(user.getName())
                .username(user.getUsername())
                .build();
    }
}
