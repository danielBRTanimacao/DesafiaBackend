package daniel.Desafia.dtos.challenges.request;

import daniel.Desafia.enums.DifficultyEnum;
import daniel.Desafia.enums.StatusEnum;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public record UpdateRequestChallengeDTO(
        @NotBlank
        Long id,
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
