package com.example.demo.controller;

import com.example.demo.model.BudgetPlan;
import com.example.demo.service.BudgetPlanService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/budgets")
public class BudgetPlanController {

    private final BudgetPlanService budgetPlanService;

    public BudgetPlanController(BudgetPlanService budgetPlanService) {
        this.budgetPlanService = budgetPlanService;
    }

    @PostMapping
    public BudgetPlan createBudget(@RequestBody BudgetPlan budgetPlan) {
        return budgetPlanService.createBudgetPlan(budgetPlan);
    }

    @GetMapping
    public List<BudgetPlan> getAllBudgets() {
        return budgetPlanService.getAllBudgetPlans();
    }

    @GetMapping("/{id}")
    public BudgetPlan getBudgetById(@PathVariable Long id) {
        return budgetPlanService.getBudgetPlanById(id);
    }
}
