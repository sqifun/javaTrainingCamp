package com.sqifun.jtc.week7;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * @program: part2
 * @className: InsertDemo3
 * @description:
 * @author: sqi
 * @date: 2022-02-27 20:29
 * @version: 1.0
 **/
public class InsertDemo3 {

    /**
     * 插入大概 1m30s
     * @param orderInfos 对象
     */

    public void insertData(List<OrderInfo> orderInfos) {
        Connection conn = JdbcUtils.getConnection();
        Statement state = null;
        try {
            state = conn.createStatement();
            StringBuilder sql = new StringBuilder("insert into order_info (" +
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
                    "values ");
            for (OrderInfo orderInfo : orderInfos) {
                sql.append("(")
                        .append(orderInfo.getId()).append(",")
                        .append(orderInfo.getNumber()).append(",")
                        .append(orderInfo.getUserId()).append(",")
                        .append(orderInfo.getUserAddressId()).append(",")
                        .append(orderInfo.getProductId()).append(",")
                        .append(orderInfo.getPaymentMethod()).append(",")
                        .append(orderInfo.getOriginMoney()).append(",")
                        .append(orderInfo.getDistrictMoney()).append(",")
                        .append(orderInfo.getExpressMoney()).append(",")
                        .append(orderInfo.getPaymentMoney()).append(",'")
                        .append(orderInfo.getExpressCompany()).append("',")
                        .append(orderInfo.getExpressNumber()).append(",'")
                        .append(new java.sql.Date(orderInfo.getPayTime().getTime())).append("','")
                        .append(new java.sql.Date(orderInfo.getSendTime().getTime())).append("','")
                        .append(new java.sql.Date(orderInfo.getReceiveTime().getTime())).append("',")
                        .append(orderInfo.getStatus()).append(",'")
                        .append(new java.sql.Date(orderInfo.getCreateTime().getTime())).append("','")
                        .append(new java.sql.Date(orderInfo.getUpdateTime().getTime())).append("',")
                        .append(orderInfo.getIsValid()).append(",'")
                        .append(orderInfo.getRemark()).append("'),");
            }
            String s = sql.substring(0, sql.length() - 1);
            state.executeUpdate(s);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.closeResource(conn, state);
        }
    }

}