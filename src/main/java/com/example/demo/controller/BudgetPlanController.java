package com.example.demo.controller;

import com.example.demo.entity.BudgetPlan;
import com.example.demo.repository.BudgetPlanRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/budget-plans")
public class BudgetPlanController {

    private final BudgetPlanRepository budgetPlanRepository;

    public BudgetPlanController(BudgetPlanRepository budgetPlanRepository) {
        this.budgetPlanRepository = budgetPlanRepository;
    }

    @GetMapping
    public List<BudgetPlan> getAllPlans() {
        return budgetPlanRepository.findAll();
    }

    @PostMapping
    public BudgetPlan createPlan(@RequestBody BudgetPlan plan) {
        return budgetPlanRepository.save(plan);
    }
}
