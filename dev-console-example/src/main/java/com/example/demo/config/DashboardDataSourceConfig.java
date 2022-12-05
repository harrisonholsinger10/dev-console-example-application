package com.example.demo.config;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class DashboardDataSourceConfig {

    @Bean
    @ConfigurationProperties("spring.datasource.dashboard")
    public DataSourceProperties dashboardDataSourceProperties() {return new DataSourceProperties();}

    @Bean
    //@Primary
    @ConfigurationProperties("spring.datasource.dashboard.hikari")
    public DataSource dashboardDataSource() {
        return dashboardDataSourceProperties()
                .initializeDataSourceBuilder()
                .build();
    }

}
