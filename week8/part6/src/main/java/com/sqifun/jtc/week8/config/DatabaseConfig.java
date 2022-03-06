package com.sqifun.jtc.week8.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;


/**
 * @program: week8-part6
 * @className: DatabaseConfig
 * @description:
 * @author: sqi
 * @date: 2022-03-06 20:29
 * @version: 1.0
 **/
@Configuration
@EnableTransactionManagement
public class DatabaseConfig {

    @Bean
    public PlatformTransactionManager txManager(final DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

}