package daniel.Desafia.controllers.challenges;

import daniel.Desafia.dtos.challenges.request.CreateRequestChallengeDTO;
import daniel.Desafia.dtos.challenges.request.UpdateRequestChallengeDTO;
import daniel.Desafia.entities.ChallengeEntity;
import daniel.Desafia.services.challenges.ChallengeService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChallengeControllerImpl implements ChallengeController {

    private final ChallengeService service;

    public ChallengeControllerImpl(ChallengeService service) {
        this.service = service;
    }

    @Override
    public ResponseEntity<Page<ChallengeEntity>> getAllChallenges(int page, int size) {
        return ResponseEntity.ok().body(service.paginateChallenges(page, size));
    }

    @Override
    public ResponseEntity<ChallengeEntity> createNewChallenge(CreateRequestChallengeDTO data) {
        return ResponseEntity.ok().body(service.saveChallenge(data));
    }

    @Override
    public ResponseEntity<Void> updateChallenge(UpdateRequestChallengeDTO data) {
        return null;
    }
}
