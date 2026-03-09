package daniel.Desafia.services.challenges;

import daniel.Desafia.entities.CategoryEntity;
import daniel.Desafia.entities.ChallengeEntity;
import daniel.Desafia.enums.DifficultyEnum;
import daniel.Desafia.enums.StatusEnum;
import daniel.Desafia.repositories.CategoryRepository;
import daniel.Desafia.repositories.ChallengeRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ChallengeServiceImpl implements ChallengeService{

    private final ChallengeRepository repository;
    private final CategoryRepository categoryRepository;

    public ChallengeServiceImpl(ChallengeRepository repository,CategoryRepository categoryRepository) {
        this.repository = repository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Page<ChallengeEntity> paginateChallenges(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return this.repository.findAll(pageable);
    }

    @Override
    public ChallengeEntity foo() {
        CategoryEntity cat = new CategoryEntity();
        ChallengeEntity challenge = new ChallengeEntity();

        cat.setName("CATEGORIA");
        challenge.setCategory(cat);
        challenge.setDescription("teste");
        challenge.setDifficulty(DifficultyEnum.MEDIUM);
        challenge.setStartDate(LocalDateTime.now());
        challenge.setStatus(StatusEnum.ACTIVE);
        challenge.setTitle("Titulo teste");
        challenge.setXpReward(1000);

        categoryRepository.save(cat);
        repository.save(challenge);

        return challenge;
    }
}
