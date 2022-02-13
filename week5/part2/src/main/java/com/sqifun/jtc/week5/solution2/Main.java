package com.sqifun.jtc.week5.solution2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @program: week5-part2
 * @className: Solution1
 * @description:
 * @author: sqi
 * @date: 2022-02-12 16:40
 * @version: 1.0
 **/
@Component
public class Main {

    private static Person person;

    @Autowired
    public void setPerson(Person person) {
        Main.person = person;
    }

    public static void main(String[] args) {
        new ClassPathXmlApplicationContext("spring-2.xml");
        person.print();
    }

}