package com.example.demo.repository;

import java.util.Optional;
import com.example.demo.model.User;

public interface UserRepository {
    Optional<User> findById(Long id);
    boolean existsByEmail(String email);
    User save(User user);
}
