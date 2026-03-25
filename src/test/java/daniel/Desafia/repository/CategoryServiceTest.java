package daniel.Desafia.repository;

import daniel.Desafia.dtos.categories.request.*;
import daniel.Desafia.repositories.CategoryRepository;
import daniel.Desafia.services.categories.CategoryServiceImpl;
import daniel.Desafia.utils.customs.AlreadyExistException;
import daniel.Desafia.utils.customs.NotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CategoryServiceTest {

    @InjectMocks
    private CategoryServiceImpl service;

    @Mock
    private CategoryRepository repository;

    private final Long fakeId = 9999999L;

    @Test
    void shouldThrowNotFoundExceptionWhenDeletingNonExistingCategory() {
        when(repository.findById(fakeId)).thenReturn(Optional.empty());
        assertThrows(NotFoundException.class, () -> service.delCategory(fakeId));

        Mockito.verify(repository).findById(fakeId);
        Mockito.verify(repository, Mockito.never()).deleteById(fakeId);
    }

    @Test
    void shouldThrowAlreadyExistExceptionWhenSameNameCategoryCreated() {
        String repeatName = "Gym";
        CreateRequestCategoryDTO dto = new CreateRequestCategoryDTO(repeatName, new byte[5]);

        when(repository.findByNameExists(repeatName))
                .thenReturn(false)
                .thenReturn(true);

        service.saveCategory(dto);

        assertThrows(AlreadyExistException.class, () -> service.saveCategory(dto));
    }

    @Test
    void shouldThrowNotFoundExceptionWhenUpdateNonExistingCategory() {
        UpdateRequestCategoryDTO categoryDTO = new UpdateRequestCategoryDTO(fakeId, "Name", new byte[5]);

        when(repository.findById(fakeId)).thenReturn(Optional.empty());
        assertThrows(NotFoundException.class, () -> service.updateCategory(categoryDTO));
    }
}
