package com.example.demo.service.impl;

import com.example.demo.exception.BadRequestException;
import com.example.demo.model.Category;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.service.CategoryService;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository repo;

    public CategoryServiceImpl(CategoryRepository r) {
        this.repo = r;
    }

    public Category addCategory(Category c) {
        if (repo.existsByName(c.getName())) {
            throw new BadRequestException("Duplicate category");
        }
        c.validateType();
        return repo.save(c);
    }

    public List<Category> getAllCategories() {
        return repo.findAll();
    }
}
