package com.example.demo.service.impl;

import com.example.demo.exception.BadRequestException;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UserServiceImpl implements UserService {

    private final UserRepository repo;
    private final PasswordEncoder encoder;

    public UserServiceImpl(UserRepository r, PasswordEncoder e) {
        this.repo = r;
        this.encoder = e;
    }

    public User register(User u) {
        if (repo.existsByEmail(u.getEmail())) {
            throw new BadRequestException("Duplicate email");
        }
        u.setRole(User.ROLE_USER);
        return repo.save(u);
    }
}
