package com.jiangcl.javabase.jdbc.connectionpool.druid;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

/**
 * @author jiangcl
 * @date 2019/12/12
 * @desc druid数据库连接池
 */
public class DruidPoolEx {

    private static DataSource dataSource = null;

    static {
        try {
            InputStream in = ClassLoader.getSystemClassLoader().getResourceAsStream("druid.properties");
            Properties pro = new Properties();
            pro.load(in);

            dataSource = DruidDataSourceFactory.createDataSource(pro);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test1() throws Exception {
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
    }
}
