package com.example.demo.service.impl;

import com.example.demo.repository.TransactionRepository;
import com.example.demo.service.BudgetSummaryService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class BudgetSummaryServiceImpl implements BudgetSummaryService {

    private final TransactionRepository transactionRepository;

    public BudgetSummaryServiceImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public BigDecimal getTotalExpense() {
        return transactionRepository.sumExpenses();
    }
}
