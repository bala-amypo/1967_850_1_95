package com.example.demo.service;

import com.example.demo.model.Category;
import java.util.List;

public interface CategoryService {

    List<?> getAll();

    Category create(Category category);

    // ✅ ADD
    Category update(Long id, Category category);
}
