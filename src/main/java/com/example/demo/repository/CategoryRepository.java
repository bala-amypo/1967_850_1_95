package com.example.demo.repository;

import com.example.demo.model.Category;
import java.util.List;

public interface CategoryRepository {
    boolean existsByName(String name);
    List<Category> findAll();
    Category save(Category category);
}
