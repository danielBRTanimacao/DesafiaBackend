package daniel.Desafia.entities;

import daniel.Desafia.enums.StatusEnum;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "participants")
public class ParticipantsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "challenge_id", nullable = false)
    private ChallengeEntity challenge;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusEnum status;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime joinedAt;

    private LocalDateTime completedAt;
}
