package com.example.demo.model;

import java.time.LocalDateTime;

public class BudgetSummary {
    public static final String STATUS_UNDER_LIMIT = "UNDER_LIMIT";

    private Long id;
    private BudgetPlan budgetPlan;
    private Double totalIncome;
    private Double totalExpense;
    private String status;
    private LocalDateTime generatedAt;

    public BudgetSummary() {}

    public BudgetSummary(Long id, BudgetPlan plan, Double income,
                         Double expense, String status, LocalDateTime time) {
        this.id = id;
        this.budgetPlan = plan;
        this.totalIncome = income;
        this.totalExpense = expense;
        this.status = status;
        this.generatedAt = time;
    }

    public void onCreate() {
        this.generatedAt = LocalDateTime.now();
    }

    public void setStatus(String status) { this.status = status; }
    public String getStatus() { return status; }
    public void setBudgetPlan(BudgetPlan plan) { this.budgetPlan = plan; }
    public BudgetPlan getBudgetPlan() { return budgetPlan; }
    public LocalDateTime getGeneratedAt() { return generatedAt; }
}
