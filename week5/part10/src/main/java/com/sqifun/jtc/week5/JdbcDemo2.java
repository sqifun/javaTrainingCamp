package com.sqifun.jtc.week5;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: week5-part10
 * @className: JdbcDemo2
 * @description:
 * @author: sqi
 * @date: 2022-02-13 21:32
 * @version: 1.0
 **/
public class JdbcDemo2 {

    public void create(Person person) {
        Connection conn = JdbcUtils.getConnection();
        PreparedStatement ps = null;
        try {
            String sql = "insert into person (id, name) values (?, ?)";
            ps = conn.prepareStatement(sql);
            ps.setObject(1, person.getId());
            ps.setObject(2, person.getName());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.closeResource(conn, ps);
        }
    }

    public void modify(Person person) {
        Connection conn = JdbcUtils.getConnection();
        PreparedStatement ps = null;
        try {
            String sql = "update person set name = ? where id = ?";
            ps = conn.prepareStatement(sql);
            ps.setObject(1, person.getName());
            ps.setObject(2, person.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.closeResource(conn, ps);
        }
    }

    public void delete(Person person) {
        Connection conn = JdbcUtils.getConnection();
        PreparedStatement ps = null;
        try {
            String sql = "delete from person where id = ?";
            ps = conn.prepareStatement(sql);
            ps.setObject(1, person.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.closeResource(conn, ps);
        }
    }

    public Person queryById(int id) {
        Connection conn = JdbcUtils.getConnection();
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        List<Person> result = new ArrayList<>();
        try {
            String sql ="select * from person where id = ?";
            ps = conn.prepareStatement(sql);
            ps.setObject(1, id);
            resultSet = ps.executeQuery();
            while(resultSet.next()) {
                Person person = new Person();
                person.setId(resultSet.getInt(1));
                person.setName(resultSet.getString(2));
                result.add(person);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.closeResource(conn, ps, resultSet);
        }
        if (result.size() == 0) {
            return null;
        }
        return result.get(0);
    }

    /**
     * 批处理，事务
     */
    public void creatBatch() {
        Connection conn = JdbcUtils.getConnection();
        PreparedStatement ps = null;
        try {
            conn.setAutoCommit(false);
            String sql = "insert into person (id, name) values (?, ?)";
            ps = conn.prepareStatement(sql);
            for(int i = 0; i < 100; i++) {
                /*if (i == 50) {
                    throw new Exception("抛出异常");
                }*/
                ps.setInt(1, i + 10);
                ps.setString(2, "name" + i);
                ps.addBatch();
            }
            ps.executeBatch();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                conn.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } finally {
            try {
                conn.commit();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            JdbcUtils.closeResource(conn, ps);
        }
    }

}