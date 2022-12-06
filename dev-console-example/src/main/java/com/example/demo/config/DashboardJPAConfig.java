package com.example.demo.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Objects;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackages = "com.example.demo.repositories",
        entityManagerFactoryRef = "dashboardEntityManagerFactory",
        transactionManagerRef = "dashboardTransactionManager"
)

public class DashboardJPAConfig {

    @Bean
    public LocalContainerEntityManagerFactoryBean dashboardEntityManagerFactory(
            @Qualifier("dashboardDataSource") DataSource dataSource,
            EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(dataSource)
                .packages("com.example.demo.entities")
                .build();
    }

    @Bean
    public PlatformTransactionManager dashboardTransactionManager(
            @Qualifier("dashboardEntityManagerFactory") LocalContainerEntityManagerFactoryBean dashboardEntityManagerFactory) {
        return new JpaTransactionManager(Objects.requireNonNull(dashboardEntityManagerFactory.getObject()));
    }

}
