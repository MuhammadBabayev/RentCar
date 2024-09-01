package org.example.rentcar.service;

import org.example.rentcar.dto.Users.CreateUserDTO;
import org.example.rentcar.dto.Users.GetUserDTO;
import org.example.rentcar.dto.Users.UpdateUserDTO;
import org.example.rentcar.entity.Users;
import org.example.rentcar.exception.NotFoundException;
import org.example.rentcar.mapper.user.UserCreateMapper;
import org.example.rentcar.mapper.user.UserGetMapper;
import org.example.rentcar.mapper.user.UserUpdateMapper;
import org.example.rentcar.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static java.lang.String.format;
import static org.example.rentcar.enums.ExceptionMessage.NOT_FOUND;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public Users save(CreateUserDTO createUserDTO) {
        Users user = UserCreateMapper.dtoToEntity(createUserDTO);
        return userRepository.save(user);
    }

    public void updateUserBalance(Long userId, Double balance) {
        Optional<Users> user = userRepository.findById(userId);
        if (user.isPresent()) {
            Users userEntity = user.get();
            userEntity.setBalance(userEntity.getBalance() - balance);
            userRepository.save(userEntity);
        }

    }

    public Users getUserById(Long id) {
        return userRepository.findByIdAndStatus(id, "A")
                .stream()
                .findFirst()
                .orElseThrow(() ->new NotFoundException(
                        format(
                               NOT_FOUND.getMessage(),
                                id
                        )));
    }

    public GetUserDTO getUserDTOById(Long id) {
        Users user = getUserById(id);
        return UserGetMapper.entityToDto(user);
    }

    public void delete(Long id) {
       Optional<Users> user = userRepository.findByIdAndStatus(id, "A");
       if(user.isPresent()){
           user.get().setStatus("D");
           userRepository.save(user.get());
       }
    }

    public Users getUserByUsername(String username) {
        Optional<Users> users = userRepository.findByUserNameAndStatus(username,"A");
        return users.orElse(null);
    }

    public Users updateUser(UpdateUserDTO updateUserDTO) {
        Users user = UserUpdateMapper.dtoToEntity(updateUserDTO);
        return userRepository.save(user);
    }

    public Users saveOneUser(Users newUser) {
        return userRepository.save(newUser);
    }
}
