package com.sqifun.jtc.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * @program: jtc-spring-boot-starter
 * @className: Student
 * @description:
 * @author: sqi
 * @date: 2022-02-13 13:22
 * @version: 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Student implements Serializable {

    private static final long serialVersionUID = -8195397273822794178L;

    private int id;

    private String name;

}