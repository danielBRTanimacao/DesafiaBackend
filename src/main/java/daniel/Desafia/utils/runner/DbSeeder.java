package daniel.Desafia.utils.runner;

import daniel.Desafia.entities.CategoryEntity;
import daniel.Desafia.entities.ChallengeEntity;
import daniel.Desafia.enums.DifficultyEnum;
import daniel.Desafia.enums.StatusEnum;
import daniel.Desafia.repositories.CategoryRepository;
import daniel.Desafia.repositories.ChallengeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DbSeeder {

    @Bean
    CommandLineRunner initDbCategory(CategoryRepository repo) {
        return args -> {
            if (repo.count() == 0) {
                repo.save(new CategoryEntity("Gym"));
                repo.save(new CategoryEntity("Technology"));
                repo.save(new CategoryEntity("Social"));
            }
        };
    }

    @Bean
    CommandLineRunner initDbChallenge(ChallengeRepository repo) {
        return args -> {
            if (repo.count() == 0) {
                repo.save(new ChallengeEntity(1L, "Desafio", "descrição", DifficultyEnum.EASY, 50, StatusEnum.ACTIVE));
            }
        };
    }
}
