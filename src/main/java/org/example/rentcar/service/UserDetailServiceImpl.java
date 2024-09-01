package org.example.rentcar.service;

import org.example.rentcar.entity.Users;
import org.example.rentcar.repository.UserRepository;
import org.example.rentcar.security.JWTUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Users user = userRepository.findByUserName(userName);
        return JWTUserDetails.create(user);
    }

    public UserDetails loadUserById(Long id) {
        Users user = userRepository.findById(id).get();
        return JWTUserDetails.create(user);
    }
}
