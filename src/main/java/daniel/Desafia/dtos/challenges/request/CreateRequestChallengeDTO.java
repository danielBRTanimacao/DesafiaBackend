package daniel.Desafia.dtos.challenges.request;


import java.time.LocalDateTime;

public record CreateRequestChallengeDTO(
        String title,
        int xpReward,
        LocalDateTime startDate,
        LocalDateTime endDate
) {
}
