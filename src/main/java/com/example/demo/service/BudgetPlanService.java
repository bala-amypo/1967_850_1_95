package com.example.demo.service;

import com.example.demo.model.*;
import java.util.List;
public interface BudgetPlanService {
    BudgetPlan createBudgetPlan(Long userId, BudgetPlan plan);
    BudgetPlan getBudgetPlan(Long userId, Integer month, Integer year);
}
