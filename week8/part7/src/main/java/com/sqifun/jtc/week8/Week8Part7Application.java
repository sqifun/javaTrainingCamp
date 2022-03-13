package com.sqifun.jtc.week8;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.sqifun.jtc.week8.mapper")
public class Week8Part7Application {

    public static void main(String[] args) {
        SpringApplication.run(Week8Part7Application.class, args);
    }

}
