package com.example.demo.repository;

import java.util.Optional;
import com.example.demo.model.*;

public interface BudgetSummaryRepository {
    Optional<BudgetSummary> findByBudgetPlan(BudgetPlan plan);
}
