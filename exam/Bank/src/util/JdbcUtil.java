package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * 单例获取链接
 *
 * @author aiboleepro
 * @date 2018-01-16 下午2:51
 **/
public class JdbcUtil {

    /**
     * 饿汉式单例类.在类初始化时，已经自行实例化
     */
    private static JdbcUtil jdbcUtil = new JdbcUtil();

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
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Common?useUnicode=true&characterEncoding=UTF8&useSSL=false","root","root");
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
            if(null != resultSet){
                resultSet.close();
            }
            if(null != statement){
                statement.close();
            }
            if(null != con){
                con.close();
            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("释放连接及句柄失败...");
        }
    }
}
