@Entity
public class BudgetSummary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double totalIncome;
    private Double totalExpense;
    private String status;

    @Column(nullable = false)
    private LocalDateTime generatedAt;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "budget_plan_id")
    private BudgetPlan budgetPlan;

    // getters & setters unchanged
}
