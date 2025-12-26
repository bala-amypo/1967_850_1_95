package com.example.demo.repository;

import com.example.demo.model.*;
import java.time.LocalDate;
import java.util.*;

public interface UserRepository {
    boolean existsByEmail(String email);
    Optional<User> findById(Long id);
    User save(User user);
}
