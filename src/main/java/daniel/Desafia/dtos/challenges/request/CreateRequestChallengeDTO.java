package daniel.Desafia.dtos.challenges.request;


import daniel.Desafia.enums.DifficultyEnum;
import daniel.Desafia.enums.StatusEnum;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public record CreateRequestChallengeDTO(
        @NotBlank
        Long category_id,
        @NotBlank
        String title,
        String description,
        DifficultyEnum difficulty,
        @NotBlank
        int xpReward,
        byte[] image,
        StatusEnum status,
        @NotBlank
        LocalDateTime startDate,
        @NotBlank
        LocalDateTime endDate
) {}
