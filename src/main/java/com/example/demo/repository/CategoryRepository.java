package com.example.demo.repository;

import java.util.*;
import com.example.demo.model.Category;

public interface CategoryRepository {
    boolean existsByName(String name);
    Category save(Category category);
    List<Category> findAll();
}
