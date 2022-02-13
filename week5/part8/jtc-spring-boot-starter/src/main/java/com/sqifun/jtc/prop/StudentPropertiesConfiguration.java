package com.sqifun.jtc.prop;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @program: jtc-spring-boot-starter
 * @className: SpringBootPropertiesConfiguration
 * @description:
 * @author: sqi
 * @date: 2022-02-13 13:24
 * @version: 1.0
 **/
@ConfigurationProperties(prefix = "jtc.student")
@Getter
@Setter
public class StudentPropertiesConfiguration {

    private int id = 0;

    private String name = "-";

}