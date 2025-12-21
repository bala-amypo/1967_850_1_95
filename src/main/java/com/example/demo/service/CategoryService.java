package com.example.demo.service;

import com.example.demo.model.*;
import java.util.List;
public interface CategoryService {
    Category addCategory(Category category);
    List<Category> getAllCategories();
}
