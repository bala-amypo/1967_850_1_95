package com.example.demo.service;

import com.example.demo.model.Category;
import java.util.List;

public interface CategoryService {

    List<?> getAll();

    // ✅ ADD
    Category create(Category category);
}
