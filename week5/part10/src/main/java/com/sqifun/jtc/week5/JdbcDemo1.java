package com.sqifun.jtc.week5;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: week5-part10
 * @className: JdbcDemo1
 * @description:
 * @author: sqi
 * @date: 2022-02-13 21:32
 * @version: 1.0
 **/
public class JdbcDemo1 {

    public void create(Person person) {
        Connection conn = JdbcUtils.getConnection();
        Statement state = null;
        try {
            state = conn.createStatement();
            String sql = "insert into person (id, name) values (" + person.getId() + ", '" + person.getName() + "')";
            state.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.closeResource(conn, state);
        }
    }

    public void modify(Person person) {
        Connection conn = JdbcUtils.getConnection();
        Statement state = null;
        try {
            state = conn.createStatement();
            String sql = "update person set name = '" + person.getName() + "' where id = " + person.getId();
            state.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.closeResource(conn, state);
        }
    }

    public void delete(Person person) {
        Connection conn = JdbcUtils.getConnection();
        Statement state = null;
        try {
            state = conn.createStatement();
            String sql = "delete from person where id = " + person.getId();
            state.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.closeResource(conn, state);
        }
    }

    public List<Person> query() {
        Connection conn = JdbcUtils.getConnection();
        Statement state = null;
        ResultSet resultSet = null;
        List<Person> result = new ArrayList<>();
        try {
            state = conn.createStatement();
            String sql ="select * from person";
            resultSet = state.executeQuery(sql);
            while(resultSet.next()) {
                Person person = new Person();
                person.setId(resultSet.getInt(1));
                person.setName(resultSet.getString(2));
                result.add(person);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.closeResource(conn, state, resultSet);
        }
        return result;
    }

}