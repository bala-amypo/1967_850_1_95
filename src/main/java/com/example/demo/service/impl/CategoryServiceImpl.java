package com.example.demo.service.impl;

import com.example.demo.model.Category;
import com.example.demo.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Override
    public Category addCategory(Category category) {
        // stub implementation
        return category;
    }

    @Override
    public List<Category> getAllCategories() {
        // stub implementation
        return Collections.emptyList();
    }
}
