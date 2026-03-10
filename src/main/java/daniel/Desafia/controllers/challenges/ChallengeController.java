package daniel.Desafia.controllers.challenges;

import daniel.Desafia.dtos.challenges.request.CreateRequestChallengeDTO;
import daniel.Desafia.entities.ChallengeEntity;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/challenges")
public interface ChallengeController {
    @GetMapping
    ResponseEntity<Page<ChallengeEntity>> getAllChallenges(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    );

    @PostMapping
    ResponseEntity<ChallengeEntity> createNewChallenge(@RequestBody CreateRequestChallengeDTO data);
}
