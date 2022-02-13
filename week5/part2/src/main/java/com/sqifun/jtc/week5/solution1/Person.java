package com.sqifun.jtc.week5.solution1;

import lombok.Data;

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
public class Person implements Serializable {

    private static final long serialVersionUID = 4959543707395786282L;

    private int id;

    private String name;

    public void print() {
        System.out.println("装配方式一");
    }

}