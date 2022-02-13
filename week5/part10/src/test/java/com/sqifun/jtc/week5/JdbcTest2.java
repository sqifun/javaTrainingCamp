package com.sqifun.jtc.week5;

import org.junit.Test;

/**
 * @program: week5-part10
 * @className: JdbcTest2
 * @description:
 * @author: sqi
 * @date: 2022-02-13 21:27
 * @version: 1.0
 **/
public class JdbcTest2 {

    @Test
    public void create() {
        JdbcDemo2 jdbcDemo2 = new JdbcDemo2();
        Person person = new Person(3, "王");
        jdbcDemo2.create(person);
    }

    @Test
    public void modify() {
        JdbcDemo2 jdbcDemo2 = new JdbcDemo2();
        Person person = new Person(3, "王五");
        jdbcDemo2.modify(person);
    }

    @Test
    public void query() {
        JdbcDemo2 jdbcDemo2 = new JdbcDemo2();
        Person result = jdbcDemo2.queryById(3);
        System.out.println(result);
    }

    @Test
    public void delete() {
        JdbcDemo2 jdbcDemo2 = new JdbcDemo2();
        Person person = new Person(3, "王五");
        jdbcDemo2.delete(person);
    }

    @Test
    public void createBatch() {
        JdbcDemo2 jdbcDemo2 = new JdbcDemo2();
        jdbcDemo2.creatBatch();
    }

}