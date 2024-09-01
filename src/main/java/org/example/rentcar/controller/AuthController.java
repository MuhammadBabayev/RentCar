package org.example.rentcar.controller;

import org.example.rentcar.dto.request.UserRequest;
import org.example.rentcar.entity.Users;
import org.example.rentcar.security.JWTTokenProvider;
import org.example.rentcar.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;

    private final JWTTokenProvider tokenProvider;

    private final UserService userService;

    private final PasswordEncoder passwordEncoder;



    @PostMapping("/login")
    public String login(@RequestBody UserRequest loginRequest) {
        UsernamePasswordAuthenticationToken authToken =
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword());
        Authentication auth = authenticationManager.authenticate(authToken);
        SecurityContextHolder.getContext().setAuthentication(auth);
        String jwtToken = tokenProvider.generateJwtToken(auth);
        return "Baerer " + jwtToken;
    }


    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody UserRequest registerRequest) {
        if (userService.getUserByUsername(registerRequest.getUsername()) != null) {
            return new ResponseEntity<>("Username is already taken", HttpStatus.BAD_REQUEST);
        }

        Users user = new Users();
        user.setUserName(registerRequest.getUsername());
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        userService.saveOneUser(user);
        return new ResponseEntity<>("User succesfully registered", HttpStatus.CREATED);
    }
}
