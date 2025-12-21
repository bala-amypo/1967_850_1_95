package com.example.demo.service;

import com.example.demo.entity.BudgetPlan;
import java.util.List;

public interface BudgetPlanService {
    List<BudgetPlan> findAll();
    BudgetPlan create(BudgetPlan plan);
}
