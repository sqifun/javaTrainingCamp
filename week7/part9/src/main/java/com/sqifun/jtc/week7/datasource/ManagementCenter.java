package com.sqifun.jtc.week7.datasource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

/**
 * @program: part9
 * @className: ManagementCenter
 * @description:
 * @author: sqi
 * @date: 2022-02-27 21:41
 * @version: 1.0
 **/
@Component
public class ManagementCenter {

    @Autowired
    @Qualifier("master")
    DataSource masterDataSource;
    @Autowired
    @Qualifier("slave1")
    DataSource slave1DataSource;
    @Autowired
    @Qualifier("slave2")
    DataSource slave2DataSource;

    int slaveIndex = 1;

    public DataSource getDefaultDataSource() {
        return masterDataSource;
    }

    /**
     * 这里就简单的模拟一下负载均衡
     */
    public DataSource getSlaveDataSource() {
        if (slaveIndex == 1) {
            slaveIndex = 2;
            return slave1DataSource;
        }
        slaveIndex = 1;
        return slave2DataSource;
    }
}