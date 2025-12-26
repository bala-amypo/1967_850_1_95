package com.example.demo.service.impl;

import com.example.demo.exception.BadRequestException;
import com.example.demo.model.BudgetPlan;
import com.example.demo.repository.BudgetPlanRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.BudgetPlanService;

public class BudgetPlanServiceImpl implements BudgetPlanService {

    private final BudgetPlanRepository repo;
    private final UserRepository userRepo;

    public BudgetPlanServiceImpl(BudgetPlanRepository repo, UserRepository userRepo) {
        this.repo = repo;
        this.userRepo = userRepo;
    }

    public BudgetPlan createBudgetPlan(Long userId, BudgetPlan plan) {
        if (repo.findByUserAndMonthAndYear(
                userRepo.findById(userId).get(),
                plan.getMonth(), plan.getYear()).isPresent()) {
            throw new BadRequestException("Duplicate plan");
        }
        plan.validate();
        return repo.save(plan);
    }
}
