package com.sqifun.jtc;

import com.sqifun.jtc.bean.Klass;
import com.sqifun.jtc.bean.School;
import com.sqifun.jtc.bean.Student;
import com.sqifun.jtc.prop.KlassPropertiesConfiguration;
import com.sqifun.jtc.prop.StudentPropertiesConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: jtc-spring-boot-starter
 * @className: JtcAutoConfiguration
 * @description:
 * @author: sqi
 * @date: 2022-02-13 13:25
 * @version: 1.0
 **/
@Configuration
@ComponentScan("com.sqifun.jtc.bean")
@EnableConfigurationProperties({StudentPropertiesConfiguration.class, KlassPropertiesConfiguration.class})
public class JtcAutoConfiguration {

    @Resource
    StudentPropertiesConfiguration studentProperties;

    @Resource
    KlassPropertiesConfiguration klassProperties;

    @Bean
    public Student createStudent() {
        return new Student(studentProperties.getId(), studentProperties.getName());
    }

    @Bean
    public Klass createClass() {
        Klass klass = new Klass();
        List<Student> students = new ArrayList<>();
        List<Student> classes = klassProperties.getClasses();
        if (classes == null) {
            return klass;
        }
        for (Student aClass : classes) {
            students.add(new Student(aClass.getId(), aClass.getName()));
        }
        klass.setStudents(students);
        return klass;
    }

    @Bean
    @ConditionalOnBean({Student.class, Klass.class})
    public School createSchool() {
        return new School();
    }

}