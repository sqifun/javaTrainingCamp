package com.sqifun.jtc.prop;

import com.sqifun.jtc.bean.Student;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

/**
 * @program: jtc-spring-boot-starter
 * @className: SpringBootPropertiesConfiguration
 * @description:
 * @author: sqi
 * @date: 2022-02-13 13:24
 * @version: 1.0
 **/
@ConfigurationProperties(prefix = "jtc.classes")
@Getter
@Setter
public class KlassPropertiesConfiguration {

    private List<Student> classes;

}