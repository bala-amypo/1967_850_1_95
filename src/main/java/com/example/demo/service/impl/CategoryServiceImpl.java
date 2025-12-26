package com.example.demo.service.impl;

import com.example.demo.model.Category;
import com.example.demo.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Override
    public List<Category> getAllCategories() {
        // minimal stub
        return Collections.emptyList();
    }
}
