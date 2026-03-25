package daniel.Desafia.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import daniel.Desafia.enums.DifficultyEnum;
import daniel.Desafia.enums.StatusEnum;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "challenges")
public class ChallengeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private CategoryEntity category;

    @Column(nullable = false, length = 150, unique = true)
    private String title;
    @Column(columnDefinition = "TEXT")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private DifficultyEnum difficulty;

    private int xpReward;

    @Lob
    @Column(columnDefinition = "BLOB")
    private byte[] image;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusEnum status;

    private LocalDateTime startDate;
    private LocalDateTime endDate;

    @CreatedDate
    private LocalDateTime createdAt;
    @LastModifiedDate
    private LocalDateTime updatedAt;

    public ChallengeEntity() {}

    public ChallengeEntity(Long category_id, String title, String description, DifficultyEnum difficulty, int xpReward, StatusEnum status) {
        this.setCategoryId(category_id);
        this.title = title;
        this.description = description;
        this.difficulty = difficulty;
        this.xpReward = xpReward;
        this.status = status;
    }

    @JsonProperty("category_id")
    public Long getCategoryId() {
        return (this.category != null) ? this.category.getId() : null;
    }

    @JsonProperty("category_id")
    public void setCategoryId(Long categoryId) {
        if (this.category == null) {
            this.category = new CategoryEntity();
        }
        this.category.setId(categoryId);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public DifficultyEnum getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(DifficultyEnum difficulty) {
        this.difficulty = difficulty;
    }

    public int getXpReward() {
        return xpReward;
    }

    public void setXpReward(int xpReward) {
        this.xpReward = xpReward;
    }

    public byte[] getImgUrl() {
        return image;
    }

    public void setImgUrl(byte[] imgUrl) {
        this.image = imgUrl;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
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

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }
}
