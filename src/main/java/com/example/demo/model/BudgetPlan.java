package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class BudgetPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer budgetMonth;
    private Integer budgetYear;
    private Double incomeTarget;
    private Double expenseLimit;

    @ManyToOne
    private User user;
}
