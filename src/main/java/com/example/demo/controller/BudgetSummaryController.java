package com.example.demo.controller;

import com.example.demo.model.BudgetSummary;
import com.example.demo.service.BudgetSummaryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/budget-summaries")
public class BudgetSummaryController {

    private final BudgetSummaryService budgetSummaryService;

    public BudgetSummaryController(BudgetSummaryService budgetSummaryService) {
        this.budgetSummaryService = budgetSummaryService;
    }

    @PostMapping
    public BudgetSummary createSummary(@RequestBody BudgetSummary summary) {
        return budgetSummaryService.createSummary(summary);
    }

    @GetMapping
    public List<BudgetSummary> getAllSummaries() {
        return budgetSummaryService.getAllSummaries();
    }

    @GetMapping("/{id}")
    public BudgetSummary getSummary(@PathVariable Long id) {
        return budgetSummaryService.getSummaryById(id);
    }
}
