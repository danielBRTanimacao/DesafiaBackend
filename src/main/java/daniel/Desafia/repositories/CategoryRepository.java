package daniel.Desafia.repositories;

import daniel.Desafia.entities.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
    boolean findByNameExists(String name);
}
