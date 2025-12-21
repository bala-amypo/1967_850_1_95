package com.example.demo.service.impl;

import com.example.demo.entity.BudgetPlan;
import com.example.demo.repository.BudgetPlanRepository;
import com.example.demo.service.BudgetPlanService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BudgetPlanServiceImpl implements BudgetPlanService {

    private final BudgetPlanRepository repository;

    public BudgetPlanServiceImpl(BudgetPlanRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<BudgetPlan> findAll() {
        return repository.findAll();
    }

    @Override
    public BudgetPlan create(BudgetPlan plan) {
        return repository.save(plan);
    }
}
