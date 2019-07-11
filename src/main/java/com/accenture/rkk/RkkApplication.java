package com.accenture.rkk;

import liquibase.util.LiquibaseUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class RkkApplication {
    public static void main(String[] args) {
        SpringApplication.run(RkkApplication.class, args);
        System.out.println("Liquibase build version:" + LiquibaseUtil.getBuildVersion());


    }

}
