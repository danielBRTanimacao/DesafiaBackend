package daniel.Desafia.services.categories;

import daniel.Desafia.entities.CategoryEntity;
import daniel.Desafia.repositories.CategoryRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;


@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository repository;

    public CategoryServiceImpl(CategoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public Page<CategoryEntity> pageCategories(int page, int size) {
        return null;
    }

    @Override
    public void saveCategory(CategoryEntity entity) {
        this.repository.save(entity);
    }
}
