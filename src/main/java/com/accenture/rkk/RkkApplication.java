package com.accenture.rkk;

import liquibase.util.LiquibaseUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@SpringBootApplication
@Configuration
public class RkkApplication {
    @Bean
    public DataSource getDataSource() {
        return DataSourceBuilder
                .create()
                .url("jdbc:h2:C:/ee/java_projects/rkk/src/main/resources/db/db2")
                .username("h2")
                .password("h2")
                .driverClassName("org.h2.Driver")
                .build();
    }
    public static void main(String[] args) {
        SpringApplication.run(RkkApplication.class, args);
        System.out.println("Liquibase build version:" + LiquibaseUtil.getBuildVersion());
    }

}
