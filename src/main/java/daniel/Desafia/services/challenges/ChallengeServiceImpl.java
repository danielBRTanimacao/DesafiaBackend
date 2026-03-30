package daniel.Desafia.services.challenges;

import daniel.Desafia.dtos.challenges.request.*;
import daniel.Desafia.entities.ChallengeEntity;
import daniel.Desafia.repositories.ChallengeRepository;
import daniel.Desafia.utils.customs.AlreadyExistException;
import daniel.Desafia.utils.customs.NotFoundException;
import jakarta.transaction.Transactional;
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

    @Override
    public ChallengeEntity saveChallenge(CreateRequestChallengeDTO data) {
        if (this.repository.findByTitleExists(data.title())) {
            throw new AlreadyExistException("Challenge with name" + data.title() + " already exist");
        }
        ChallengeEntity challenge = new ChallengeEntity();

        challenge.setTitle(data.title());
        challenge.setStatus(data.status());
        challenge.setXpReward(data.xpReward());
        challenge.setDescription(data.description());
        challenge.setDifficulty(data.difficulty());
        challenge.setCategoryId(data.category_id());
        challenge.setStartDate(data.startDate());
        challenge.setEndDate(data.endDate());
        challenge.setImg(data.image());
        return this.repository.save(challenge);
    }

    @Override
    @Transactional
    public void updateChallenge(UpdateRequestChallengeDTO data) {

        ChallengeEntity challenge = this.repository.findById(data.id())
                .orElseThrow(() -> new NotFoundException("Challenge not found"));

        if (data.title() != null && !data.title().isBlank()) {
            challenge.setTitle(data.title());
        }
        if (data.description() != null && !data.description().isBlank()) {
            challenge.setDescription(data.description());
        }
        if (data.status() != null) {
            challenge.setStatus(data.status());
        }
        if (data.difficulty() != null) {
            challenge.setDifficulty(data.difficulty());
        }
        if (data.xpReward() > 0) {
            challenge.setXpReward(data.xpReward());
        }
        if (data.startDate() != null) challenge.setStartDate(data.startDate());
        if (data.endDate() != null) challenge.setEndDate(data.endDate());
        if (data.category_id() != null) {
            challenge.setCategoryId(data.category_id());
        }
        if (data.image() != null) {
            challenge.setImg(data.image());
        }

        this.repository.save(challenge);
    }

    @Override
    public void delChallenge(Long id) {
        ChallengeEntity challenge = repository.findById(id).orElseThrow(
                () -> new NotFoundException("Challenge not found")
        );
        repository.delete(challenge);
    }
}
