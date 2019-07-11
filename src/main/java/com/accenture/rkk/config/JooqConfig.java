package com.accenture.rkk.config;

import org.jooq.impl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jooq.JooqExceptionTranslator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy;

import javax.sql.DataSource;

@Configuration
public class JooqConfig {
    @Autowired
    JooqConfig(DataSource datasource){
        this.datasource = datasource;
    }
    private DataSource datasource;
    @Bean
    public DataSourceConnectionProvider connectionProvider(){
        return new DataSourceConnectionProvider(
                new TransactionAwareDataSourceProxy(datasource)
        );
    }
    @Bean
    public DefaultDSLContext dsl(){
        return new DefaultDSLContext(configuration());
    }
    public DefaultConfiguration configuration(){
        DefaultConfiguration jooqConfiguration = new DefaultConfiguration();
        jooqConfiguration.set(connectionProvider());
        jooqConfiguration.set(new DefaultExecuteListenerProvider(new JooqExceptionTranslator()));
        return jooqConfiguration;
    }
}
