package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.BudgetPlan;
import com.example.demo.model.BudgetSummary;
import com.example.demo.model.TransactionLog;
import com.example.demo.repository.BudgetPlanRepository;
import com.example.demo.repository.BudgetSummaryRepository;
import com.example.demo.repository.TransactionLogRepository;
import com.example.demo.service.BudgetSummaryService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BudgetSummaryServiceImpl implements BudgetSummaryService {

    private final BudgetSummaryRepository budgetSummaryRepository;
    private final BudgetPlanRepository budgetPlanRepository;
    private final TransactionLogRepository transactionLogRepository;

    public BudgetSummaryServiceImpl(
            BudgetSummaryRepository budgetSummaryRepository,
            BudgetPlanRepository budgetPlanRepository,
            TransactionLogRepository transactionLogRepository) {

        this.budgetSummaryRepository = budgetSummaryRepository;
        this.budgetPlanRepository = budgetPlanRepository;
        this.transactionLogRepository = transactionLogRepository;
    }

    @Override
    public BudgetSummary generateSummary(Long budgetPlanId) {
        BudgetPlan plan = budgetPlanRepository.findById(budgetPlanId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Budget plan not found"));

        LocalDate start = LocalDate.of(plan.getYear(), plan.getMonth(), 1);
        LocalDate end = start.withDayOfMonth(start.lengthOfMonth());

        List<TransactionLog> logs =
                transactionLogRepository.findByUserAndTransactionDateBetween(
                        plan.getUser(), start, end);

        double income = 0;
        double expense = 0;

        for (TransactionLog log : logs) {
            if ("INCOME".equals(log.getCategory().getType())) {
                income += log.getAmount();
            } else {
                expense += log.getAmount();
            }
        }

        String status = expense <= plan.getExpenseLimit()
                ? BudgetSummary.UNDER_LIMIT
                : BudgetSummary.OVER_LIMIT;

        BudgetSummary summary = new BudgetSummary(
                null, plan, income, expense, status, null);

        return budgetSummaryRepository.save(summary);
    }

    @Override
    public BudgetSummary getSummary(Long budgetPlanId) {
        BudgetPlan plan = budgetPlanRepository.findById(budgetPlanId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Budget plan not found"));

        return budgetSummaryRepository.findByBudgetPlan(plan)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Summary not found"));
    }
}
