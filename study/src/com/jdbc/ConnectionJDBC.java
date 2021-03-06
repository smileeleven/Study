package com.jdbc;

import java.sql.*;

/**
 * JDBC链接测试
 *
 * @author aiboleepro
 * @date 2018-01-16 下午1:48
 **/
public class ConnectionJDBC {

    public static void main(String[] args) throws Exception {

        JdbcUtil jdbcUtil = JdbcUtil.getInstance();
        for(int i=0;i<5;i++){
            Connection connection = jdbcUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM role");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String id = resultSet.getString("id");
                String name = resultSet.getString("name");
                System.out.println(id + " | " + name);
            }
            jdbcUtil.release(connection,preparedStatement,resultSet);
        }
    }
}
