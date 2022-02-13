package com.sqifun.jtc.bean;

import lombok.Data;

import java.util.List;

/**
 * @program: jtc-spring-boot-starter
 * @className: Klass
 * @description:
 * @author: sqi
 * @date: 2022-02-13 13:22
 * @version: 1.0
 **/
@Data
public class Klass {

    List<Student> students;

    public void dong(){
        System.out.println(this.getStudents());
    }

}