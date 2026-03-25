package daniel.Desafia.repository;

import daniel.Desafia.repositories.ChallengeRepository;
import daniel.Desafia.services.challenges.ChallengeServiceImpl;
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
}
