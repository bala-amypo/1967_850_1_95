package com.example.demo.service;

import com.example.demo.model.BudgetSummary;
import com.example.demo.model.BudgetPlan;
import java.util.Optional;

public interface BudgetSummaryService {
    Optional<BudgetSummary> getSummaryByPlan(BudgetPlan plan);
}
