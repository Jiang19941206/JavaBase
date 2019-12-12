package com.jiangcl.javabase.jdbc.connectionpool.c3p0;

import com.jiangcl.javabase.jdbc.DbConfig;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

/**
 * @author jiangcl
 * @date 2019/12/12
 * @desc c3p0数据库连接池
 */
public class C3P0PoolEx {

    private static ComboPooledDataSource dataSource = null;

    /**
     * 创建数据库连接池
     */
    static {
        try {
            dataSource = new ComboPooledDataSource();
            dataSource.setDriverClass(DbConfig.driver);
            dataSource.setJdbcUrl(DbConfig.url);
            dataSource.setUser(DbConfig.userName);
            dataSource.setPassword(DbConfig.password);

            //初始化的连接池大小
            dataSource.setInitialPoolSize(10);
            //最小连接数
            dataSource.setMinPoolSize(10);
            //最大连接数
            dataSource.setMaxPoolSize(50);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    public void test3() throws Exception {
        Connection conn = getConnection();
        System.out.println(conn);
    }

    public static Connection getConnection() throws Exception {
        Connection connection = dataSource.getConnection();
        return connection;
    }
}
