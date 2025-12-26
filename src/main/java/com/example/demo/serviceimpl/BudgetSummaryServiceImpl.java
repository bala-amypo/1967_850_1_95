package com.example.demo.service.impl;

import com.example.demo.repository.BudgetPlanRepository;
import com.example.demo.repository.BudgetSummaryRepository;
import com.example.demo.repository.TransactionLogRepository;
import com.example.demo.service.BudgetSummaryService;

public class BudgetSummaryServiceImpl implements BudgetSummaryService {

    public BudgetSummaryServiceImpl(BudgetSummaryRepository summaryRepository,
                                    BudgetPlanRepository planRepository,
                                    TransactionLogRepository transactionLogRepository) {
        // No-op (test-driven stub)
    }
}
