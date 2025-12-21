package com.example.demo.service;

import com.example.demo.model.BudgetPlan;

import java.util.List;

public interface BudgetPlanService {

    BudgetPlan createBudgetPlan(BudgetPlan budgetPlan);

    List<BudgetPlan> getAllBudgetPlans();

    BudgetPlan getBudgetPlanById(Long id);
}
