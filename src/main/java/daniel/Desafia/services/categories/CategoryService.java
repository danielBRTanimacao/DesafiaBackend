package daniel.Desafia.services.categories;

import daniel.Desafia.entities.CategoryEntity;
import org.springframework.data.domain.Page;

public interface CategoryService {
    Page<CategoryEntity> pageCategories(int page, int size);
    void saveCategory(CategoryEntity entity);
    void updateCategory(CategoryEntity data);
    void delCategory(Long id);
}
