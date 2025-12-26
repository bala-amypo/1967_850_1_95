package com.example.demo.repository;

import java.util.Optional;
import com.example.demo.model.*;

public interface BudgetPlanRepository {
    Optional<BudgetPlan> findByUserAndMonthAndYear(User user, Integer month, Integer year);
    BudgetPlan save(BudgetPlan plan);
}
