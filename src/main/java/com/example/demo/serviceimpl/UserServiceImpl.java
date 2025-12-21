package com.example.demo.service.impl;

import com.example.demo.exception.BadRequestException;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

import java.util.Optional;

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    // ✅ Constructor injection ONLY
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User register(User user) {

        if (userRepository.existsByEmail(user.getEmail())) {
            throw new BadRequestException("Email already exists");
        }

        // ✅ NO password encoding (security excluded)
        if (user.getRole() == null) {
            user.setRole("USER");
        }

        return userRepository.save(user);
    }

    @Override
    public User findByEmail(String email) {
        Optional<User> user = userRepository.findAll()
                .stream()
                .filter(u -> u.getEmail().equals(email))
                .findFirst();

        return user.orElse(null);
    }
}
