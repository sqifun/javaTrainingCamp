package com.sqifun.jtc.week5.solution3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @program: week5-part2
 * @className: Main
 * @description:
 * @author: sqi
 * @date: 2022-02-13 16:35
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
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        Person person = (Person) context.getBean("person");
        person.print();
    }

}