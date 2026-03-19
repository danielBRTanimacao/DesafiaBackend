package daniel.Desafia.utils.runner;

import daniel.Desafia.entities.CategoryEntity;
import daniel.Desafia.repositories.CategoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DbSeeder {

    @Bean
    CommandLineRunner initDatabase(CategoryRepository repo) {
        return args -> {
            if (repo.count() == 0) {
                repo.save(new CategoryEntity("Gym"));
            }
        };
    }
}
