package com.example.demo.model;

import com.example.demo.exception.BadRequestException;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "budget_plans")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class BudgetPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    private Integer month;
    private Integer year;

    private Double incomeTarget;
    private Double expenseLimit;

    @OneToOne(mappedBy = "budgetPlan")
    private BudgetSummary budgetSummary;

    public void validate() {
        if (month < 1 || month > 12) {
            throw new BadRequestException("Month must be between 1 and 12");
        }
        if (incomeTarget < 0 || expenseLimit < 0) {
            throw new BadRequestException("Amounts must be >= 0");
        }
    }
}
