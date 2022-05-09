package pl.coderslab.dogs;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = "pl.coderslab")
@EnableJpaRepositories(basePackages = "pl.coderslab.dogs")
@EnableTransactionManagement
public class AppConfig {
}
