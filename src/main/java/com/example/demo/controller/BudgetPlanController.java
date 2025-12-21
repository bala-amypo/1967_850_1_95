package com.example.demo.controller;

import com.example.demo.model.BudgetPlan;
import com.example.demo.service.BudgetPlanService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/budgets")
public class BudgetPlanController {

    private final BudgetPlanService service;

    public BudgetPlanController(BudgetPlanService service) {
        this.service = service;
    }

    @PostMapping("/{userId}")
    public BudgetPlan createPlan(
            @PathVariable Long userId,
            @RequestBody BudgetPlan plan) {

        return service.createBudgetPlan(userId, plan);
    }

    @GetMapping("/{userId}/{month}/{year}")
    public BudgetPlan getPlan(
            @PathVariable Long userId,
            @PathVariable Integer month,
            @PathVariable Integer year) {

        return service.getBudgetPlan(userId, month, year);
    }
}
