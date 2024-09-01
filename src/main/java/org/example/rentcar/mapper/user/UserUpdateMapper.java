package org.example.rentcar.mapper.user;

import org.example.rentcar.dto.Users.UpdateUserDTO;
import org.example.rentcar.entity.Users;

public class UserUpdateMapper {

    public static Users dtoToEntity(UpdateUserDTO updateUserDTO) {
        return Users.builder()
                .phone(updateUserDTO.getUsername())
                .email(updateUserDTO.getEmail())
                .name(updateUserDTO.getName())
                .balance(updateUserDTO.getBalance())
                .licence(updateUserDTO.getLicence())
                .userName(updateUserDTO.getUsername())
                .build();
    }
}
