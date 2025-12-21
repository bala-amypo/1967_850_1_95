package com.example.demo.model;

import java.time.LocalDateTime;
import jakarta.persistence.*;

@Entity
public class BudgetSummary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private BudgetPlan budgetPlan;

    private Double totalIncome;
    private Double totalExpenses;
    private String status;
    private LocalDateTime generatedAt;

    @PrePersist
    public void onCreate() {
        generatedAt = LocalDateTime.now();
    }

    public BudgetSummary() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public BudgetPlan getBudgetPlan() { return budgetPlan; }
    public void setBudgetPlan(BudgetPlan budgetPlan) { this.budgetPlan = budgetPlan; }

    public Double getTotalIncome() { return totalIncome; }
    public void setTotalIncome(Double totalIncome) { this.totalIncome = totalIncome; }

    public Double getTotalExpenses() { return totalExpenses; }
    public void setTotalExpenses(Double totalExpenses) { this.totalExpenses = totalExpenses; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public LocalDateTime getGeneratedAt() { return generatedAt; }
}
