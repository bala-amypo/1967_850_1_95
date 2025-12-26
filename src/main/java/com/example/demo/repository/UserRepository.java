package com.example.demo.repository;

import com.example.demo.model.*;
import java.time.LocalDate;
import java.util.*;

public interface UserRepository {
    Optional<User> findById(Long id);
    boolean existsByEmail(String email);
    User save(User user);
}
