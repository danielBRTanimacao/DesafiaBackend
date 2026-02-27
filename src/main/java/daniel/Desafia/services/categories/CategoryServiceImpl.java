package daniel.Desafia.services.categories;

import daniel.Desafia.entities.CategoryEntity;
import daniel.Desafia.repositories.CategoryRepository;
import org.springframework.stereotype.Service;


@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository repository;

    public CategoryServiceImpl(CategoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public void saveCategory(CategoryEntity entity) {
        this.repository.save(entity);
    }
}
