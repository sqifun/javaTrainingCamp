package com.sqifun.jtc.week9;

import com.sqifun.jtc.week9.api.TransactionAService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @program: week9-part7
 * @className: ClientApplication
 * @description:
 * @author: sqi
 * @date: 2022-03-13 14:51
 * @version: 1.0
 **/
@SpringBootApplication
public class ClientApplication {

    @DubboReference(version = "1.0.0")
    private TransactionAService transactionAService;

    public static void main(String[] args) {
        SpringApplication.run(ClientApplication.class, args);
    }

    @Bean
    public ApplicationRunner runner() {
        return args -> {
            transactionAService.exchangeDollar("a", "b", 700.0);
        };
    }

}