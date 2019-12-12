package com.jiangcl.javabase.jdbc.transcation;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author jiangcl
 * @date 2019/12/12
 * @desc 数据库事物测试
 */
public class TranscationEx {

    @Test
    public void update(){
        Connection conn = null;
        PreparedStatement pre1 = null;
        PreparedStatement pre2 = null;
        try {
            conn = getConnection();
            //取消事务的自动提交
            conn.setAutoCommit(false);
            String u1 = "UPDATE bank_account SET total = 1200 where id = 1";
            String u2 = "UPDATE bank_account SET total = 800 where id = 2";
            pre1 = conn.prepareStatement(u1);
            //当autocommit = true是，一旦执行操作语句就自动提交事务
            boolean execute1 = pre1.execute();
            //System.out.println(1/0);
            pre2 = conn.prepareStatement(u2);
            boolean execute2 = pre2.execute();
            //当所有操作都正常执行后才提交事物
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            //若出现异常，则进行事物回滚
            try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        } finally {
            if(conn != null){
                try {
                    //在关闭连接前将自动提交恢复为true,防止重复使用连接时无法提交事务。
                    conn.setAutoCommit(true);
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }if(pre1 != null){
                try {
                    pre1.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }if(pre2 != null){
                try {
                    pre2.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    /**
     * 连接获取
     * @return
     */
    public Connection getConnection(){
        Connection connection = null;
        InputStream in = null;
        try {
            //获取配置文件
            in = ClassLoader.getSystemClassLoader().getResourceAsStream("db.properties");
            Properties properties = new Properties();
            properties.load(in);

            //获取配置文件中的属性值
            String url = (String) properties.get("url");
            String userName = (String) properties.get("userName");
            String password = (String) properties.get("password");
            String driver = (String) properties.get("driver");

            //加载驱动
            Class.forName(driver);

            //获取连接
            connection = DriverManager.getConnection(url, userName, password);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(in != null){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return connection;
    }
}
