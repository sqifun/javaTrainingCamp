package com.sqifun.jtc.week5;

import org.junit.Test;

/**
 * @program: week5-part10
 * @className: JdbcTest3
 * @description:
 * @author: sqi
 * @date: 2022-02-13 21:27
 * @version: 1.0
 **/
public class JdbcTest3 {

    @Test
    public void create() {
        JdbcDemo3 jdbcDemo3 = new JdbcDemo3();
        Person person = new Person(2, "李四");
        jdbcDemo3.create(person);
    }

}