package com.sqifun.jtc.bean;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

/**
 * @program: jtc-spring-boot-starter
 * @className: School
 * @description:
 * @author: sqi
 * @date: 2022-02-13 13:22
 * @version: 1.0
 **/
@Data
public class School {

    @Autowired
    Klass klass;

    @Resource
    Student student;

    public void ding(){
        System.out.println("Class1 have " + this.klass.getStudents().size() + " students and one is " + this.student);
    }

}