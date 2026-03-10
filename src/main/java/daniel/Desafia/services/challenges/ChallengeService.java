package daniel.Desafia.services.challenges;

import daniel.Desafia.entities.ChallengeEntity;
import org.springframework.data.domain.Page;

public interface ChallengeService {
    Page<ChallengeEntity> paginateChallenges(int page, int size);
    ChallengeEntity saveChallenge(ChallengeEntity entity);
}
