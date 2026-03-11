package daniel.Desafia.controllers.categories;

import daniel.Desafia.dtos.categories.request.*;
import daniel.Desafia.entities.CategoryEntity;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/categories")
public interface CategoryController {
    @GetMapping
    ResponseEntity<Page<CategoryEntity>> getAllCategories(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    );

    @PostMapping
    ResponseEntity<Void> createNewCategory(@RequestBody CreateRequestCategoryDTO data);

    @PutMapping
    ResponseEntity<Void> updateCategory(@RequestBody UpdateRequestCategoryDTO data);

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deletingCategory(@PathVariable Long id);
}
