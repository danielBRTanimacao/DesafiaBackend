package daniel.Desafia.services.challenges;

import daniel.Desafia.dtos.challenges.request.CreateRequestChallengeDTO;
import daniel.Desafia.dtos.challenges.request.UpdateRequestChallengeDTO;
import daniel.Desafia.entities.ChallengeEntity;
import org.springframework.data.domain.Page;

public interface ChallengeService {
    Page<ChallengeEntity> paginateChallenges(int page, int size);
    ChallengeEntity saveChallenge(CreateRequestChallengeDTO data);
    void updateChallenge(UpdateRequestChallengeDTO data);
    void delChallenge(Long id);
}
