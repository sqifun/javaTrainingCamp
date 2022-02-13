package com.sqifun.jtc.week5.solution3;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @program: week5-part2
 * @className: Config
 * @description:
 * @author: sqi
 * @date: 2022-02-13 16:37
 * @version: 1.0
 **/
@Configuration
@ComponentScan("com.sqifun.jtc.week5.solution3")
public class Config {

    @Bean
    public Person getPerson() {
        return new Person();
    }

}