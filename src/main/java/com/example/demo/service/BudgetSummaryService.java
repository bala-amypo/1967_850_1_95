package com.example.demo.service;

import com.example.demo.model.BudgetSummary;
import java.util.List;

public interface BudgetSummaryService {

    List<?> getAll();

    // ✅ ADD
    BudgetSummary create(BudgetSummary summary);
}
