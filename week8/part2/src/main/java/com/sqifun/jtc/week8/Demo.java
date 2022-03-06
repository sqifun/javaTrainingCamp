package com.sqifun.jtc.week8;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: week8-part2
 * @className: Demo
 * @description:
 * @author: sqi
 * @date: 2022-03-06 16:51
 * @version: 1.0
 **/
public class Demo {

    public void insertData(List<OrderInfo> orderInfos) {
        Connection conn = JdbcUtils.getConnection();
        PreparedStatement ps = null;
        try {
            conn.setAutoCommit(false);
            String sql = "insert into order_info (" +
                    "id," +
                    "number," +
                    "user_id," +
                    "user_address_id," +
                    "product_id," +
                    "payment_method," +
                    "origin_money," +
                    "district_money," +
                    "express_money," +
                    "payment_money," +
                    "express_company," +
                    "express_number," +
                    "pay_time," +
                    "send_time," +
                    "receive_time," +
                    "status," +
                    "create_time," +
                    "update_time," +
                    "is_valid," +
                    "remark) " +
                    "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            ps = conn.prepareStatement(sql);
            for (OrderInfo orderInfo : orderInfos) {
                ps.setLong(1, orderInfo.getId());
                ps.setLong(2, orderInfo.getNumber());
                ps.setLong(3, orderInfo.getUserId());
                ps.setLong(4, orderInfo.getUserAddressId());
                ps.setLong(5, orderInfo.getProductId());
                ps.setInt(6, orderInfo.getPaymentMethod());
                ps.setDouble(7, orderInfo.getOriginMoney());
                ps.setDouble(8, orderInfo.getDistrictMoney());
                ps.setDouble(9, orderInfo.getExpressMoney());
                ps.setDouble(10, orderInfo.getPaymentMoney());
                ps.setString(11, orderInfo.getExpressCompany());
                ps.setLong(12, orderInfo.getExpressNumber());
                ps.setObject(13, orderInfo.getPayTime());
                ps.setObject(14, orderInfo.getSendTime());
                ps.setObject(15, orderInfo.getReceiveTime());
                ps.setInt(16, orderInfo.getStatus());
                ps.setObject(17, orderInfo.getCreateTime());
                ps.setObject(18, orderInfo.getUpdateTime());
                ps.setInt(19, orderInfo.getIsValid());
                ps.setString(20, orderInfo.getRemark());
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

    public void updateRemarkById(Long id, String remark) {
        Connection conn = JdbcUtils.getConnection();
        Statement state = null;
        try {
            state = conn.createStatement();
            String sql = "update order_info set remark = '" + remark + "' where id = " + id;
            state.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.closeResource(conn, state);
        }
    }

    public void deleteById(Long id) {
        Connection conn = JdbcUtils.getConnection();
        Statement state = null;
        try {
            state = conn.createStatement();
            String sql = "delete from order_info where id = " + id;
            state.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.closeResource(conn, state);
        }
    }

    public void delete() {
        Connection conn = JdbcUtils.getConnection();
        Statement state = null;
        try {
            state = conn.createStatement();
            String sql = "delete from order_info";
            state.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.closeResource(conn, state);
        }
    }

    public List<OrderInfo> query() {
        Connection conn = JdbcUtils.getConnection();
        Statement state = null;
        ResultSet resultSet = null;
        List<OrderInfo> result = new ArrayList<>();
        try {
            state = conn.createStatement();
            String sql ="select * from person";
            resultSet = state.executeQuery(sql);
            while(resultSet.next()) {
                OrderInfo person = new OrderInfo();
                person.setId(resultSet.getLong(1));
                person.setNumber(resultSet.getLong(2));
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