package org.example.rentcar.controller;

import org.example.rentcar.dto.Users.CreateUserDTO;
import org.example.rentcar.dto.Users.GetUserDTO;
import org.example.rentcar.entity.Users;
import org.example.rentcar.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("create")
    public ResponseEntity<Users> createUser(@RequestBody CreateUserDTO user) {
         return ResponseEntity.ok(userService.save(user));
    }

    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long userId) {
        userService.delete(userId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{userId}")
    public ResponseEntity<GetUserDTO> getUser(@PathVariable Long userId) {
        return ResponseEntity.ok(userService.getUserDTOById(userId));
    }

}
