package daniel.Desafia.dtos.challenges.request;


import daniel.Desafia.enums.DifficultyEnum;
import daniel.Desafia.enums.StatusEnum;

import java.time.LocalDateTime;

public record CreateRequestChallengeDTO(
        Long category_id,
        String title,
        String description,
        DifficultyEnum difficulty,
        int xpReward,
        byte[] image,
        StatusEnum status,
        LocalDateTime startDate,
        LocalDateTime endDate
) {
}
