package com.sqifun.jtc.week5;

import org.junit.Test;

import java.util.List;

/**
 * @program: week5-part10
 * @className: JdbcTest1
 * @description:
 * @author: sqi
 * @date: 2022-02-13 21:27
 * @version: 1.0
 **/
public class JdbcTest1 {

    @Test
    public void create() {
        JdbcDemo1 jdbcDemo1 = new JdbcDemo1();
        Person person = new Person(3, "王");
        jdbcDemo1.create(person);
    }

    @Test
    public void modify() {
        JdbcDemo1 jdbcDemo1 = new JdbcDemo1();
        Person person = new Person(3, "王五");
        jdbcDemo1.modify(person);
    }

    @Test
    public void query() {
        JdbcDemo1 jdbcDemo1 = new JdbcDemo1();
        List<Person> result = jdbcDemo1.query();
        System.out.println(result);
    }

    @Test
    public void delete() {
        JdbcDemo1 jdbcDemo1 = new JdbcDemo1();
        Person person = new Person(3, "王五");
        jdbcDemo1.delete(person);
    }

}