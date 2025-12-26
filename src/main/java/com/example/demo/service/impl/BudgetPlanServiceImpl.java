package com.example.demo.service.impl;

import com.example.demo.model.BudgetPlan;
import com.example.demo.repository.BudgetPlanRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.BudgetPlanService;

public class BudgetPlanServiceImpl implements BudgetPlanService {

    private BudgetPlanRepository budgetPlanRepository;
    private UserRepository userRepository;

    // REQUIRED by tests
    public BudgetPlanServiceImpl() {
    }

    // OPTIONAL for Spring
    public BudgetPlanServiceImpl(BudgetPlanRepository budgetPlanRepository,
                                 UserRepository userRepository) {
        this.budgetPlanRepository = budgetPlanRepository;
        this.userRepository = userRepository;
    }

    @Override
    public BudgetPlan createBudgetPlan(Long userId, BudgetPlan budgetPlan) {
        return budgetPlanRepository.save(budgetPlan);
    }
}
