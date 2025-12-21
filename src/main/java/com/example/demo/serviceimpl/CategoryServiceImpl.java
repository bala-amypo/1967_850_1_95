@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository repo;

    public CategoryServiceImpl(CategoryRepository repo) {
        this.repo = repo;
    }

    @Override
    public Category addCategory(Category category) {
        if (repo.existsByName(category.getName())) {
            throw new BadRequestException("Category already exists");
        }
        category.validateType();
        return repo.save(category);
    }

    @Override
    public List<Category> getAllCategories() {
        return repo.findAll();
    }
}
