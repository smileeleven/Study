package com.jdbc;

import com.alibaba.druid.pool.DruidDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * 单例获取链接
 *
 * @author aiboleepro
 * @date 2018-01-16 下午2:51
 **/
public class JdbcUtil {

    //驱动程序就是之前在classpath中配置的JDBC的驱动程序的JAR 包中
    private static final String DBDRIVER = "com.mysql.jdbc.Driver";
    //连接地址是由各个数据库生产商单独提供的，所以需要单独记住
    private static final String DBURL = "jdbc:mysql://127.0.0.1:3306/Common?useUnicode=true&characterEncoding=UTF8&useSSL=false";
    //连接数据库的用户名
    private static final String DBUSER = "root";
    //连接数据库的密码
    private static final String DBPASS = "root";
    //饿汉式单例类.在类初始化时，已经自行实例化
    private static final JdbcUtil jdbcUtil = new JdbcUtil();
    // druid 数据源
    private static DruidDataSource dataSource = null;

    static {
        try{
            dataSource = new DruidDataSource();
            dataSource.setDriverClassName(DBDRIVER);
            dataSource.setUrl(DBURL);
            dataSource.setUsername(DBUSER);
            dataSource.setPassword(DBPASS);
            dataSource.setInitialSize(5);
            dataSource.setMinIdle(1);
            dataSource.setMaxActive(10);
            dataSource.setPoolPreparedStatements(true);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("初始化数据源失败....");
        }
    }

    /**
     * 静态工厂方法
     * */
    public static JdbcUtil getInstance(){
        return jdbcUtil;
    }

    /**
     * 获取连接
     * */
    public synchronized Connection getConnection(){
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("获取数据库连接失败...");
        }
        return conn;
    }

    /**
     * 释放连接及句柄
     * */
    public void release(Connection con, PreparedStatement statement, ResultSet resultSet){
        try{
            resultSet.close();
            statement.close();
            con.close();
        }catch (Exception e){
            System.out.println("释放连接及句柄失败...");
        }
    }


}
