package daniel.Desafia.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private UUID id;

    private String username;
    private String email;
    private String password;

    private String avatarUrl;
    private String bio;
    private int xp;
    private int level;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
