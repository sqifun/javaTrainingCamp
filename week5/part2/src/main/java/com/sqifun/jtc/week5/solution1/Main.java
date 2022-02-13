package com.sqifun.jtc.week5.solution1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @program: week5-part2
 * @className: Solution1
 * @description:
 * @author: sqi
 * @date: 2022-02-12 16:40
 * @version: 1.0
 **/
public class Main {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("spring-1.xml");
        Person person = (Person) context.getBean("person");
        person.print();

    }

}