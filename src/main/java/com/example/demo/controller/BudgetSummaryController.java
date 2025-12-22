package com.example.demo.controller;

import com.example.demo.model.BudgetSummary;
import com.example.demo.service.BudgetSummaryService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/budget-summaries")
public class BudgetSummaryController {

    private final BudgetSummaryService service;

    public BudgetSummaryController(BudgetSummaryService service) {
        this.service = service;
    }

    @GetMapping
    public Object getAll() {
        return service.getAll();
    }

    @PostMapping
    public BudgetSummary create(@RequestBody BudgetSummary summary) {
        return service.create(summary);
    }

    @PutMapping("/{id}")
    public BudgetSummary update(
            @PathVariable Long id,
            @RequestBody BudgetSummary summary) {
        return service.update(id, summary);
    }
}
