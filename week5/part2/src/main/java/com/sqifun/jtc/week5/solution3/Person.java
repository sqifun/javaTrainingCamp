package com.sqifun.jtc.week5.solution3;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @program: week5-part2
 * @className: Person
 * @description:
 * @author: sqi
 * @date: 2022-02-12 16:40
 * @version: 1.0
 **/
@Data
@Component
public class Person implements Serializable {

    private static final long serialVersionUID = -5583908874884643320L;

    private int id;

    private String name;

    public void print() {
        System.out.println("装配方式三");
    }

}