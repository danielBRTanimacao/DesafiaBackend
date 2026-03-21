package daniel.Desafia.services.categories;

import daniel.Desafia.dtos.categories.request.*;
import daniel.Desafia.entities.CategoryEntity;
import daniel.Desafia.repositories.CategoryRepository;
import daniel.Desafia.utils.customs.AlreadyExistException;
import daniel.Desafia.utils.customs.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository repository;

    public CategoryServiceImpl(CategoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public Page<CategoryEntity> pageCategories(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return this.repository.findAll(pageable);
    }

    @Override
    public void saveCategory(CreateRequestCategoryDTO data) {
        if (this.repository.findByNameExists(data.name())) {
            throw new AlreadyExistException("Category with name" + data.name() + " already exist");
        }
        CategoryEntity entity = new CategoryEntity(data.name(), data.icon());
        this.repository.save(entity);
    }

    @Override
    public void updateCategory(UpdateRequestCategoryDTO data) {
        CategoryEntity category = this.repository.findById(data.id()).orElseThrow(
                () -> new NotFoundException("Category not found")
        );
        if (data.name() != null && !data.name().isBlank()) {
            category.setName(data.name());
        }
        if (data.icon() != null) {
            category.setIcon(data.icon());
        }
        this.repository.save(category);
    }

    @Override
    public void delCategory(Long id) {
        CategoryEntity category = this.repository.findById(id).orElseThrow(
                ()-> new NotFoundException("Category not found")
        );
        this.repository.delete(category);
    }
}
