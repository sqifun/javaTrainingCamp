package com.sqifun.jtc.week5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @program: week5-part10
 * @className: JdbcUtils
 * @description:
 * @author: sqi
 * @date: 2022-02-13 21:32
 * @version: 1.0
 **/
public class JdbcUtils {

    private static final String URL = "jdbc:mysql://192.168.8.231:3306/jtc";
    private static final String NAME = "root";
    private static final String PWD = "123456";

    private static Connection conn = null;

    static {
        try {
            // 1.加载驱动程序
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 2.获得数据库的连接
            conn = DriverManager.getConnection(URL, NAME, PWD);
        }
        catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取数据库连接对象
     * @return Connection
     */
    public static Connection getConnection() {
        return conn;
    }

    /**
     * 关闭JDBC相关资源
     * @param connection Connection
     * @param statement Statement
     */
    public static void closeResource(Connection connection, Statement statement) {
        try {
            if (connection!=null) {
                connection.close();
            }
            if (statement!=null) {
                statement.close();
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 关闭JDBC相关资源
     * @param connection Connection
     * @param statement Statement
     * @param resultSet ResultSet
     */
    public static void closeResource(Connection connection, Statement statement, ResultSet resultSet) {
        try {
            if (connection!=null) {
                connection.close();
            }
            if (statement!=null) {
                statement.close();
            }
            if (resultSet!=null) {
                resultSet.close();
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

}