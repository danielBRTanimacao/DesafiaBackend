package daniel.Desafia.controllers.categories;

import daniel.Desafia.dtos.categories.request.*;
import daniel.Desafia.entities.CategoryEntity;
import daniel.Desafia.services.categories.CategoryService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryControllerImpl implements CategoryController {
    private final CategoryService service;

    public CategoryControllerImpl(CategoryService service) {
        this.service = service;
    }

    @Override
    public ResponseEntity<Page<CategoryEntity>> getAllCategories(int page, int size) {
        return ResponseEntity.ok().body(service.pageCategories(page, size));
    }

    @Override
    public ResponseEntity<Void> createNewCategory(CreateRequestCategoryDTO data) {
        service.saveCategory(data);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Void>updateCategory(UpdateRequestCategoryDTO data) {
        service.updateCategory(data);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<Void> deletingCategory(Long id) {
        service.delCategory(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
