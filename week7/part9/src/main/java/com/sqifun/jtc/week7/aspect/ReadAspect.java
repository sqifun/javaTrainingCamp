package com.sqifun.jtc.week7.aspect;

import com.sqifun.jtc.week7.datasource.ManagementCenter;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @program: part9
 * @className: ReadAspect
 * @description:
 * @author: sqi
 * @date: 2022-02-27 21:37
 * @version: 1.0
 **/
@Aspect
@Component
public class ReadAspect {

    @Autowired
    ManagementCenter managementCenter;

    @Pointcut("@annotation(com.sqifun.jtc.week7.annotation.ReadAnnotation)")
    public void read(){}

    /**
     * 获取参数，改变DataSource为slave节点
     */
    @Around("read()")
    public List<Map<String, Object>> setDatabaseSource(ProceedingJoinPoint point) throws Throwable {
        System.out.println("data source change......");
        Object[] argv = point.getArgs();
        argv[0] = managementCenter.getSlaveDataSource();
        return (List<Map<String, Object>>) point.proceed(argv);
    }
}