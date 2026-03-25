package daniel.Desafia.repository;

import daniel.Desafia.dtos.categories.request.CreateRequestCategoryDTO;
import daniel.Desafia.dtos.challenges.request.CreateRequestChallengeDTO;
import daniel.Desafia.enums.DifficultyEnum;
import daniel.Desafia.enums.StatusEnum;
import daniel.Desafia.repositories.ChallengeRepository;
import daniel.Desafia.services.challenges.ChallengeServiceImpl;
import daniel.Desafia.utils.customs.AlreadyExistException;
import daniel.Desafia.utils.customs.NotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ChallengeServiceTest {
    @InjectMocks
    private ChallengeServiceImpl service;

    @Mock
    private ChallengeRepository repository;

    private final Long fakeId = 9999999L;

    @Test
    void shouldThrowNotFoundExceptionWhenDeletingNonExistingChallenge() {
        when(repository.findById(fakeId)).thenReturn(Optional.empty());
        assertThrows(NotFoundException.class, () -> service.delChallenge(fakeId));

        Mockito.verify(repository).findById(fakeId);
        Mockito.verify(repository, Mockito.never()).deleteById(fakeId);
    }

    @Test
    void shouldThrowAlreadyExistExceptionWhenSameNameChallenge() {
        String repeatName = "Challenge";
        CreateRequestChallengeDTO dto = new CreateRequestChallengeDTO(1L, repeatName, "description",
                DifficultyEnum.EASY, 10, new byte[5], StatusEnum.ACTIVE, LocalDateTime.now(),
                LocalDateTime.now()
        );

        when(repository.findByTitleExists(repeatName))
                .thenReturn(false)
                .thenReturn(true);

        service.saveChallenge(dto);

        assertThrows(AlreadyExistException.class, () -> service.saveCategory(dto));
    }
}
