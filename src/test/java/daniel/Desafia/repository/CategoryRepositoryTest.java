package daniel.Desafia.repository;

import daniel.Desafia.repositories.CategoryRepository;
import daniel.Desafia.services.categories.CategoryServiceImpl;
import daniel.Desafia.utils.customs.NotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class CategoryRepositoryTest {

    @InjectMocks
    private CategoryServiceImpl service;

    @Mock
    private CategoryRepository repository;

    @Test
    void shouldThrowNotFoundExceptionWhenDeletingNonExistingCategory() {
        Long id = 6L;

        Mockito.when(repository.findById(id)).thenReturn(Optional.empty());
        assertThrows(NotFoundException.class, () -> service.delCategory(id));

        Mockito.verify(repository).findById(id);
        Mockito.verify(repository, Mockito.never()).deleteById(id);
    }

    @Test
    void shouldThrowAlreadyExistExceptionWhenSameNameCategoryCreated() {

    }
}
