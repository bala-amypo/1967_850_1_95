import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BudgetSummaryServiceImpl implements BudgetSummaryService {

    private final BudgetSummaryRepository summaryRepo;
    private final BudgetPlanRepository planRepo;
    private final TransactionLogRepository logRepo;

    public BudgetSummaryServiceImpl(
            BudgetSummaryRepository summaryRepo,
            BudgetPlanRepository planRepo,
            TransactionLogRepository logRepo) {
        this.summaryRepo = summaryRepo;
        this.planRepo = planRepo;
        this.logRepo = logRepo;
    }

    @Override
    public BudgetSummary generateSummary(Long budgetPlanId) {
        BudgetPlan plan = planRepo.findById(budgetPlanId)
                .orElseThrow(() -> new BadRequestException("Plan not found"));

        var logs = logRepo.findByUserAndTransactionDateBetween(
                plan.getUser(),
                plan.getMonth() == 1 ? plan.getYear() - 1 >= 0 ? java.time.LocalDate.of(plan.getYear(), plan.getMonth(), 1) : null : java.time.LocalDate.of(plan.getYear(), plan.getMonth(), 1),
                java.time.LocalDate.of(plan.getYear(), plan.getMonth(), 28)
        );

        double income = logs.stream()
                .filter(t -> Category.TYPE_INCOME.equals(t.getCategory().getType()))
                .mapToDouble(TransactionLog::getAmount).sum();

        double expense = logs.stream()
                .filter(t -> Category.TYPE_EXPENSE.equals(t.getCategory().getType()))
                .mapToDouble(TransactionLog::getAmount).sum();

        BudgetSummary summary = new BudgetSummary();
        summary.setBudgetPlan(plan);
        summary.setTotalIncome(income);
        summary.setTotalExpense(expense);
        summary.setStatus(
                expense <= plan.getExpenseLimit()
                        ? BudgetSummary.STATUS_UNDER_LIMIT
                        : BudgetSummary.STATUS_OVER_LIMIT
        );

        return summaryRepo.save(summary);
    }

    @Override
    public BudgetSummary getSummary(Long budgetPlanId) {
        BudgetPlan plan = planRepo.findById(budgetPlanId)
                .orElseThrow(() -> new BadRequestException("Plan not found"));
        return summaryRepo.findByBudgetPlan(plan)
                .orElseThrow(() -> new BadRequestException("Summary not found"));
    }
}
