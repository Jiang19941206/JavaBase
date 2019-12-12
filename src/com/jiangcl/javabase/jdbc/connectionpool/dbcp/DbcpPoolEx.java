package com.jiangcl.javabase.jdbc.connectionpool.dbcp;

import com.jiangcl.javabase.jdbc.DbConfig;
import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

/**
 * @author jiangcl
 * @date 2019/12/12
 * @desc dbcp数据库连接池
 */
public class DbcpPoolEx {

    /**
     * 创建方式一
     * @throws Exception
     */
    @Test
    public void test1() throws Exception{
        BasicDataSource dataSource = new BasicDataSource();

        dataSource.setDriverClassName(DbConfig.driver);
        dataSource.setUrl(DbConfig.url);
        dataSource.setUsername(DbConfig.userName);
        dataSource.setPassword(DbConfig.password);

        dataSource.setInitialSize(10);
        dataSource.setMaxActive(10);

        Connection connection = dataSource.getConnection();
        System.out.println(connection);
    }

    /**
     * 方式二
     */
    @Test
    public void test2() throws Exception{
        Properties properties = new Properties();
        //配置文件路径
        String configFilePath = "";
        InputStream in = ClassLoader.getSystemClassLoader().getResourceAsStream(configFilePath);
        properties.load(in);

        DataSource dataSource = BasicDataSourceFactory.createDataSource(properties);
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
    }
}
