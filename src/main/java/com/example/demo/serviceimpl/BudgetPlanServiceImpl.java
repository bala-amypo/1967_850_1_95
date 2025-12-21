package com.example.demo.serviceimpl;

import com.example.demo.model.BudgetPlan;
import com.example.demo.repository.BudgetPlanRepository;
import com.example.demo.service.BudgetPlanService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BudgetPlanServiceImpl implements BudgetPlanService {

    private final BudgetPlanRepository budgetPlanRepository;

    public BudgetPlanServiceImpl(BudgetPlanRepository budgetPlanRepository) {
        this.budgetPlanRepository = budgetPlanRepository;
    }

    @Override
    public BudgetPlan createBudgetPlan(BudgetPlan budgetPlan) {
        return budgetPlanRepository.save(budgetPlan);
    }

    @Override
    public List<BudgetPlan> getAllBudgetPlans() {
        return budgetPlanRepository.findAll();
    }

    @Override
    public BudgetPlan getBudgetPlanById(Long id) {
        return budgetPlanRepository.findById(id).orElse(null);
    }
}
