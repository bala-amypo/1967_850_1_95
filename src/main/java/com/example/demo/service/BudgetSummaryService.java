package com.example.demo.service;

import com.example.demo.model.*;
import java.util.List;
public interface BudgetSummaryService {
    BudgetSummary generateSummary(Long budgetPlanId);
    BudgetSummary getSummary(Long budgetPlanId);
}
