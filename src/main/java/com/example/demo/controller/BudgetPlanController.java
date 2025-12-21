package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.BudgetPlan;
import com.example.demo.service.BudgetPlanService;

@RestController
@RequestMapping("/budget-plans")
public class BudgetPlanController {

    private final BudgetPlanService service;

    public BudgetPlanController(BudgetPlanService service) {
        this.service = service;
    }

    @PostMapping("/{userId}")
    @ResponseStatus(HttpStatus.CREATED)
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
