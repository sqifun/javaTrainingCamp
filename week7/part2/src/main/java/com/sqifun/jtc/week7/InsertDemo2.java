package com.sqifun.jtc.week7;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * @program: part2
 * @className: InsertDemo2
 * @description:
 * @author: sqi
 * @date: 2022-02-27 19:37
 * @version: 1.0
 **/
public class InsertDemo2 {

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

}