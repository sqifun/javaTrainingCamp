package com.sqifun.jtc.week7.service;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

/**
 * @program: part9
 * @className: OrderService
 * @description:
 * @author: sqi
 * @date: 2022-02-27 21:42
 * @version: 1.0
 **/
public interface OrderService {

    void insertOne(DataSource dataSource, String sql);
    List<Map<String, Object>> query(DataSource dataSource, String sql);
}