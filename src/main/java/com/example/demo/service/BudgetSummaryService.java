package com.example.demo.service;

import com.example.demo.model.BudgetSummary;
import java.util.List;

public interface BudgetSummaryService {

    List<?> getAll();

    BudgetSummary create(BudgetSummary summary);

    BudgetSummary update(Long id, BudgetSummary summary);
}
