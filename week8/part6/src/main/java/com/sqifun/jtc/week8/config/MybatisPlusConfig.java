package com.sqifun.jtc.week8.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @program: week8-part6
 * @className: MybatisPlusConfig
 * @description:
 * @author: sqi
 * @date: 2022-03-06 23:50
 * @version: 1.0
 **/
@Configuration
@MapperScan("com.sqifun.jtc.week8.mapper")
public class MybatisPlusConfig {

}