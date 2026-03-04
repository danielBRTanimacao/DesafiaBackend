package daniel.Desafia.services.challenges;

import daniel.Desafia.entities.ChallengeEntity;
import daniel.Desafia.repositories.ChallengeRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ChallengeServiceImpl implements ChallengeService{

    private final ChallengeRepository repository;

    public ChallengeServiceImpl(ChallengeRepository repository) {
        this.repository = repository;
    }

    @Override
    public Page<ChallengeEntity> paginateChallenges(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return this.repository.findAll(pageable);
    }
}
