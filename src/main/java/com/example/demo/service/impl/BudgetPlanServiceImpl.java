package com.example.demo.service.impl;

import com.example.demo.model.BudgetPlan;
import com.example.demo.service.BudgetPlanService;
import org.springframework.stereotype.Service;

@Service
public class BudgetPlanServiceImpl implements BudgetPlanService {

    @Override
    public BudgetPlan createBudgetPlan(Long userId, BudgetPlan budgetPlan) {
        // minimal stub to satisfy compiler
        return budgetPlan;
    }
}
