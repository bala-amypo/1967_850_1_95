// 🔴 CHANGED FILE
package com.example.demo.service.impl;

import com.example.demo.model.BudgetPlan;
import com.example.demo.model.BudgetSummary;
import com.example.demo.repository.BudgetPlanRepository;
import com.example.demo.repository.BudgetSummaryRepository;
import com.example.demo.service.BudgetSummaryService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BudgetSummaryServiceImpl implements BudgetSummaryService {

    private final BudgetSummaryRepository repo;

    // 🔴 CHANGED (added BudgetPlanRepository)
    private final BudgetPlanRepository budgetPlanRepo;

    // 🔴 CHANGED constructor
    public BudgetSummaryServiceImpl(BudgetSummaryRepository repo,
                                    BudgetPlanRepository budgetPlanRepo) {
        this.repo = repo;
        this.budgetPlanRepo = budgetPlanRepo;
    }

    @Override
    public List<?> getAll() {
        return repo.findAll();
    }

    @Override
    public BudgetSummary create(BudgetSummary summary) {

        // 🔴 CHANGED (attach managed BudgetPlan)
        if (summary.getBudgetPlan() != null) {
            Long planId = summary.getBudgetPlan().getId();
            BudgetPlan plan = budgetPlanRepo.findById(planId)
                    .orElseThrow(() -> new RuntimeException("BudgetPlan not found"));
            summary.setBudgetPlan(plan);
        }

        summary.setGeneratedAt(LocalDateTime.now());
        return repo.save(summary);
    }

    @Override
    public BudgetSummary update(Long id, BudgetSummary summary) {

        BudgetSummary existing = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("BudgetSummary ID " + id + " not found"));

        // 🔴 CHANGED (attach managed BudgetPlan)
        if (summary.getBudgetPlan() != null) {
            Long planId = summary.getBudgetPlan().getId();
            BudgetPlan plan = budgetPlanRepo.findById(planId)
                    .orElseThrow(() -> new RuntimeException("BudgetPlan not found"));
            existing.setBudgetPlan(plan);
        }

        existing.setTotalIncome(summary.getTotalIncome());
        existing.setTotalExpense(summary.getTotalExpense());
        existing.setStatus(summary.getStatus());
        existing.setGeneratedAt(LocalDateTime.now());

        return repo.save(existing);
    }
}
