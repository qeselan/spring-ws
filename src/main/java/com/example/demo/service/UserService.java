package com.example.demo.service;

import com.example.demo.domain.user.User;
import com.example.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void goOnline(String email) {
        User user = userRepository.findByEmail(email).orElseThrow();
        user.setOnline(true);
        userRepository.save(user);
    }
}
