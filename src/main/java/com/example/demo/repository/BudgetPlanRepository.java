package com.example.demo.repository;

import com.example.demo.model.BudgetPlan;
import com.example.demo.model.User;
import java.util.Optional;

public interface BudgetPlanRepository {
    Optional<BudgetPlan> findByUserAndMonthAndYear(
            User user, Integer month, Integer year);
    BudgetPlan save(BudgetPlan plan);
}
