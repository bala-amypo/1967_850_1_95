import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BudgetPlanServiceImpl implements BudgetPlanService {

    private final BudgetPlanRepository planRepo;
    private final UserRepository userRepo;

    public BudgetPlanServiceImpl(BudgetPlanRepository planRepo, UserRepository userRepo) {
        this.planRepo = planRepo;
        this.userRepo = userRepo;
    }

    @Override
    public BudgetPlan createBudgetPlan(Long userId, BudgetPlan plan) {
        User user = userRepo.findById(userId)
                .orElseThrow(() -> new BadRequestException("User not found"));
        plan.setUser(user);
        plan.validate();

        if (planRepo.findByUserAndMonthAndYear(user, plan.getMonth(), plan.getYear()).isPresent()) {
            throw new BadRequestException("Budget plan already exists");
        }
        return planRepo.save(plan);
    }

    @Override
    public BudgetPlan getBudgetPlan(Long userId, Integer month, Integer year) {
        User user = userRepo.findById(userId)
                .orElseThrow(() -> new BadRequestException("User not found"));
        return planRepo.findByUserAndMonthAndYear(user, month, year)
                .orElseThrow(() -> new BadRequestException("Plan not found"));
    }
}
