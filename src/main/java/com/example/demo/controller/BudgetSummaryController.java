package com.example.demo.controller;

import com.example.demo.repository.TransactionRepository;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/budget-summary")
public class BudgetSummaryController {

    private final TransactionRepository transactionRepository;

    public BudgetSummaryController(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @GetMapping("/total-expense")
    public BigDecimal getTotalExpense() {
        return transactionRepository.sumExpenses();
    }
}
