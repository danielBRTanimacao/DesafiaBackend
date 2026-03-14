package daniel.Desafia.services.challenges;

import daniel.Desafia.dtos.challenges.request.CreateRequestChallengeDTO;
import daniel.Desafia.dtos.challenges.request.UpdateRequestChallengeDTO;
import daniel.Desafia.entities.ChallengeEntity;
import daniel.Desafia.repositories.ChallengeRepository;
import daniel.Desafia.utils.customs.NotFoundException;
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
        ChallengeEntity challenge = new ChallengeEntity();

        challenge.setTitle(data.title());
        challenge.setStatus(data.status());
        challenge.setXpReward(data.xpReward());
        challenge.setDescription(data.description());
        challenge.setDifficulty(data.difficulty());
        challenge.setCategoryId(data.category_id());
        challenge.setStartDate(data.startDate());
        challenge.setEndDate(data.endDate());
        challenge.setImgUrl(data.image());
        return this.repository.save(challenge);
    }

    @Override
    public void updateChallenge(UpdateRequestChallengeDTO data) {

        ChallengeEntity challenge = this.repository.findById(data.id()).orElseThrow(
                () -> new NotFoundException("Challenge not found")
        );

        challenge.setTitle(data.title());
        challenge.setStatus(data.status());
        challenge.setXpReward(data.xpReward());
        challenge.setDescription(data.description());
        challenge.setDifficulty(data.difficulty());
        challenge.setCategoryId(data.category_id());
        challenge.setStartDate(data.startDate());
        challenge.setEndDate(data.endDate());
        challenge.setImgUrl(data.image());

        this.repository.save(challenge);
    }
}
