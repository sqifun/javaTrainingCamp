package com.sqifun.jtc.week9.core.api;

import java.util.List;

/**
 * @program: week9-part3
 * @className: LoadBalancer
 * @description:
 * @author: sqi
 * @date: 2022-03-12 14:07
 * @version: 1.0
 **/
public interface LoadBalancer {

    String select(List<String> urls);

}