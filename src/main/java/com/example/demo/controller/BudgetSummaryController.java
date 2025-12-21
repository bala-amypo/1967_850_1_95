package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.BudgetSummary;
import com.example.demo.service.BudgetSummaryService;

@RestController
@RequestMapping("/budget-summaries")
public class BudgetSummaryController {

    private final BudgetSummaryService service;

    public BudgetSummaryController(BudgetSummaryService service) {
        this.service = service;
    }

    @PostMapping("/{planId}")
    @ResponseStatus(HttpStatus.CREATED)
    public BudgetSummary generateSummary(@PathVariable Long planId) {
        return service.generateSummary(planId);
    }

    @GetMapping("/{planId}")
    public BudgetSummary getSummary(@PathVariable Long planId) {
        return service.getSummary(planId);
    }
}
