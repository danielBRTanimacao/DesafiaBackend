package daniel.Desafia.services.categories;

import daniel.Desafia.dtos.categories.request.CreateRequestCategoryDTO;
import daniel.Desafia.dtos.categories.request.UpdateRequestCategoryDTO;
import daniel.Desafia.entities.CategoryEntity;
import org.springframework.data.domain.Page;

public interface CategoryService {
    Page<CategoryEntity> pageCategories(int page, int size);
    void saveCategory(CreateRequestCategoryDTO data);
    void updateCategory(UpdateRequestCategoryDTO data);
    void delCategory(Long id);
}
