package com.example.demo.service;

import com.example.demo.model.BudgetSummary;

import java.util.List;

public interface BudgetSummaryService {

    BudgetSummary createSummary(BudgetSummary summary);

    List<BudgetSummary> getAllSummaries();

    BudgetSummary getSummaryById(Long id);
}
