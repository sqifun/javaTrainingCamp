package com.sqifun.jtc.week5;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @program: week5-part10
 * @className: JdbcDemo3
 * @description:
 * @author: sqi
 * @date: 2022-02-13 21:32
 * @version: 1.0
 **/
public class JdbcDemo3 {

    public HikariDataSource getHikariDataSource() {
        HikariDataSource dataSource = null;
        try (InputStream is = JdbcDemo3.class.getClassLoader().getResourceAsStream("hikari.properties")) {
            Properties props = new Properties();
            props.load(is);
            HikariConfig config = new HikariConfig(props);
            dataSource = new HikariDataSource(config);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return dataSource;
    }

    public void create(Person person) {
        HikariDataSource hikariDataSource = getHikariDataSource();
        try {
            Connection conn = hikariDataSource.getConnection();
            String sql = "insert into person (id, name) values (?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setObject(1, person.getId());
            ps.setObject(2, person.getName());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}