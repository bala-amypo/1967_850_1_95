// 🔴 CHANGED FILE
package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class BudgetSummary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double totalIncome;
    private Double totalExpense;
    private String status;

    // 🔴 CHANGED (no nullable issue)
    private LocalDateTime generatedAt;

    // 🔴 CHANGED (removed cascade, added JoinColumn)
    @OneToOne
    @JoinColumn(name = "budget_plan_id")
    private BudgetPlan budgetPlan;

    // getters & setters unchanged
}
