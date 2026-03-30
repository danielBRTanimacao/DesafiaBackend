package daniel.Desafia.entities;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(columnDefinition = "uuid", updatable = false, nullable = false)
    private UUID id;

    @OneToMany(mappedBy = "user")
    private List<ParticipantsEntity> participations;

    @Column(unique = true, nullable = false)
    private String username;
    @Column(unique = true, nullable = false)
    private String email;
    private String mailToken;
    private String password;

    @Lob
    @Column(columnDefinition = "BLOB")
    private byte[] avatar;
    private String bio;

    @Column(columnDefinition = "int default 0")
    private int xp;
    @Column(columnDefinition = "int default 1")
    private int level;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdAt;
    @LastModifiedDate
    private LocalDateTime updatedAt;

    public UserEntity(String username, String password) {
        this.username = username;
        this.password = password;
    }


    public UserEntity(String username, String email, String mailToken, String password, byte[] avatar) {
        this.username = username;
        this.email = email;
        this.mailToken = mailToken;
        this.password = password;
        this.avatar = avatar;
    }

    public UserEntity() {}

    private boolean isExpired(LocalDateTime actualTime) {
        LocalDateTime expiredTime = this.createdAt.plusMinutes(30);
        return actualTime.isAfter(expiredTime);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public byte[] getAvatar() {
        return avatar;
    }

    public void setAvatar(byte[] avatar) {
        this.avatar = avatar;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getMailToken() {
        return mailToken;
    }

    public void setMailToken(String mailToken) {
        this.mailToken = mailToken;
    }
}
