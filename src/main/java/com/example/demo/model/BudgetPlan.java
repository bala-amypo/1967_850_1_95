package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "budget_plans")
public class BudgetPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "budget_month")
    private Integer month;

    @Column(name = "budget_year")
    private Integer year;

    @Column(name = "income_target")
    private Double incomeTarget;

    @Column(name = "expense_limit")
    private Double expenseLimit;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    // ===== Constructors =====
    public BudgetPlan() {
    }

    public BudgetPlan(Integer month, Integer year, Double incomeTarget, Double expenseLimit, User user) {
        this.month = month;
        this.year = year;
        this.incomeTarget = incomeTarget;
        this.expenseLimit = expenseLimit;
        this.user = user;
    }

    // ===== Getters & Setters =====
    public Long getId() {
        return id;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Double getIncomeTarget() {
        return incomeTarget;
    }

    public void setIncomeTarget(Double incomeTarget) {
        this.incomeTarget = incomeTarget;
    }

    public Double getExpenseLimit() {
        return expenseLimit;
    }

    public void setExpenseLimit(Double expenseLimit) {
        this.expenseLimit = expenseLimit;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
