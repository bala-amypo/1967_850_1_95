package com.example.demo.repository;

import com.example.demo.model.BudgetSummary;
import com.example.demo.model.BudgetPlan;
import java.util.Optional;

public interface BudgetSummaryRepository {
    Optional<BudgetSummary> findByBudgetPlan(BudgetPlan plan);
    BudgetSummary save(BudgetSummary summary);
}
