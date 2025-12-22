package com.example.demo.service.impl;

import com.example.demo.model.Category;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository repo;

    public CategoryServiceImpl(CategoryRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<?> getAll() {
        return repo.findAll();
    }

    @Override
    public Category create(Category category) {
        return repo.save(category);
    }

    // ✅ PUT
    @Override
    public Category update(Long id, Category category) {
        Category existing = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));

        existing.setName(category.getName());
        existing.setType(category.getType());

        return repo.save(existing);
    }
}
