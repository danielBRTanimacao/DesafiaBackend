package daniel.Desafia.controllers.categories;

import daniel.Desafia.entities.CategoryEntity;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryControllerImpl implements CategoryController {
    @Override
    public ResponseEntity<Page<CategoryEntity>> getAllCategories(int page, int size) {
        return null;
    }
}
