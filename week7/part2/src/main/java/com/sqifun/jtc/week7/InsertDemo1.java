package com.sqifun.jtc.week7;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * @program: part2
 * @className: InsertDemo1
 * @description:
 * @author: sqi
 * @date: 2022-02-27 19:11
 * @version: 1.0
 **/
public class InsertDemo1 {

    public void insertData(List<OrderInfo> orderInfos) {
        Connection conn = JdbcUtils.getConnection();
        Statement state = null;
        try {
            state = conn.createStatement();
            for (OrderInfo orderInfo : orderInfos) {
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
                        "values (" +
                        orderInfo.getId() + ", '" +
                        orderInfo.getNumber() + ", '" +
                        orderInfo.getUserId() + ", '" +
                        orderInfo.getUserAddressId() + ", '" +
                        orderInfo.getProductId() + ", '" +
                        orderInfo.getPaymentMethod() + ", '" +
                        orderInfo.getOriginMoney() + ", '" +
                        orderInfo.getDistrictMoney() + ", '" +
                        orderInfo.getExpressMoney() + ", '" +
                        orderInfo.getPaymentMoney() + ", '" +
                        orderInfo.getExpressCompany() + ", '" +
                        orderInfo.getExpressNumber() + ", '" +
                        orderInfo.getPayTime() + ", '" +
                        orderInfo.getSendTime() + ", '" +
                        orderInfo.getReceiveTime() + ", '" +
                        orderInfo.getStatus() + ", '" +
                        orderInfo.getCreateTime() + ", '" +
                        orderInfo.getUpdateTime() + ", '" +
                        orderInfo.getIsValid() + ", '" +
                        orderInfo.getRemark() + "')";
                state.executeUpdate(sql);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.closeResource(conn, state);
        }
    }

}