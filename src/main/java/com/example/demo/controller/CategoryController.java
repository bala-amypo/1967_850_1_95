package com.example.demo.controller;

import com.example.demo.model.Category;
import com.example.demo.service.CategoryService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private final CategoryService service;

    public CategoryController(CategoryService service) {
        this.service = service;
    }

    @GetMapping
    public Object getAll() {
        return service.getAll();
    }

    @PostMapping
    public Category create(@RequestBody Category category) {
        return service.create(category);
    }

    // ✅ PUT update category
    @PutMapping("/{id}")
    public Category update(
            @PathVariable Long id,
            @RequestBody Category category) {
        return service.update(id, category);
    }
}
