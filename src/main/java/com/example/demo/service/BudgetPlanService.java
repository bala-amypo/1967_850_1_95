package com.example.demo.service.impl;

import com.example.demo.exception.BadRequestException;
import com.example.demo.model.BudgetPlan;
import com.example.demo.model.User;
import com.example.demo.repository.BudgetPlanRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.BudgetPlanService;

public class BudgetPlanServiceImpl implements BudgetPlanService {

    private final BudgetPlanRepository repo;
    private final UserRepository userRepo;

    public BudgetPlanServiceImpl(BudgetPlanRepository r, UserRepository u) {
        this.repo = r;
        this.userRepo = u;
    }

    public BudgetPlan createBudgetPlan(Long userId, BudgetPlan plan) {
        User u = userRepo.findById(userId).orElseThrow();
        plan.validate();
        if (repo.findByUserAndMonthAndYear(u, plan.getMonth(), 2025).isPresent()) {
            throw new BadRequestException("Duplicate plan");
        }
        return repo.save(plan);
    }
}
