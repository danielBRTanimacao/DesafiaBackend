package daniel.Desafia.controllers.categories;

import daniel.Desafia.entities.CategoryEntity;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("api/categories")
public interface CategoryController {
    @GetMapping
    ResponseEntity<Page<CategoryEntity>> getAllCategories(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    );
}
