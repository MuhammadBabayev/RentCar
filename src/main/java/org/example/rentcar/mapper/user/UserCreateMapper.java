package org.example.rentcar.mapper.user;

import org.example.rentcar.dto.Users.CreateUserDTO;
import org.example.rentcar.entity.Users;
import org.example.rentcar.enums.Role;

public class UserCreateMapper {

    public static Users dtoToEntity(CreateUserDTO createUserDTO) {
        return Users.builder()
                .userName(createUserDTO.getUsername())
                .name(createUserDTO.getName())
                .phone(createUserDTO.getPhone())
                .email(createUserDTO.getEmail())
                .role(Role.USER)
                .licence(createUserDTO.getLicence())
                .balance(0.0)
                .build();
    }
}
