package com.sqifun.jtc;

import com.sqifun.jtc.bean.Klass;
import com.sqifun.jtc.bean.School;
import com.sqifun.jtc.bean.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * @program: jtc-spring-boot-starter
 * @className: SpringBootStarterTest
 * @description:
 * @author: sqi
 * @date: 2022-02-13 14:57
 * @version: 1.0
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SpringBootStarterTest.class)
@SpringBootApplication
public class SpringBootStarterTest {

    @Resource
    private Student student;

    @Resource
    private Klass klass;

    @Resource
    private School school;

    @Test
    public void test() {
        System.out.println(student.toString());
        System.out.println("-----------------");
        System.out.println(klass.toString());
        System.out.println("-----------------");
        System.out.println(school.toString());
    }

}