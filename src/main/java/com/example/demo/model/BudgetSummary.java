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

    public BudgetSummary(Long id, BudgetPlan plan, Double inc, Double exp,
                         String status, LocalDateTime gen) {
        this.id = id;
        this.budgetPlan = plan;
        this.totalIncome = inc;
        this.totalExpense = exp;
        this.status = status;
        this.generatedAt = gen;
    }

    public void onCreate() {
        this.generatedAt = LocalDateTime.now();
    }

    public BudgetPlan getBudgetPlan() { return budgetPlan; }
    public void setBudgetPlan(BudgetPlan p) { this.budgetPlan = p; }
    public LocalDateTime getGeneratedAt() { return generatedAt; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
