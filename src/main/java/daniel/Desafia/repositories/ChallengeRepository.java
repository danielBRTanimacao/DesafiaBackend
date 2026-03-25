package daniel.Desafia.repositories;

import daniel.Desafia.entities.ChallengeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChallengeRepository extends JpaRepository<ChallengeEntity, Long> {
    boolean findByTitleExists(String title);
}
