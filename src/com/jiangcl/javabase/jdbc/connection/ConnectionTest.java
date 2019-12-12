package com.jiangcl.javabase.jdbc.connection;

import java.io.InputStream;
import java.sql.Driver;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author jiangcl
 * @date 2019/12/11
 * @desc 数据库连接测试
 */
public class ConnectionTest {

    /**
     * 方式一
     */
    @Test
    public void test1() throws Exception {
        //加载驱动
        Driver driver = new com.mysql.jdbc.Driver();
        String url = "jdbc:mysql://localhost:3306/jiangcl?useUnicode=true&characterEncoding=utf-8";

        Properties info = new Properties();
        info.setProperty("user","root");
        info.setProperty("password","root");

        Connection connect = driver.connect(url, info);
        System.out.println(connect);
    }

    /**
     * 动态创建Driver实例
     */
    @Test
    public void test2() throws Exception {
        Class clazz = Class.forName("com.mysql.jdbc.Driver");
        Driver driver = (Driver) clazz.newInstance();
        String url = "jdbc:mysql://localhost:3306/jiangcl?useUnicode=true&characterEncoding=utf-8";

        Properties info = new Properties();
        info.setProperty("user","root");
        info.setProperty("password","root");

        Connection connect = driver.connect(url, info);
        System.out.println(connect);

    }

    /**
     * 使用DriverManager创建连接
     */
    @Test
    public void test3() throws Exception {
        /**
         * 注意：
         * Class.forName("com.mysql.jdbc.Driver");其实已经将驱动注册好了，所以可以省略下面两句
         *  Driver driver = (Driver) clazz.newInstance();
         *  DriverManager.registerDriver(driver);
         */

        //获取Driver实例
//        Class clazz = Class.forName("com.mysql.jdbc.Driver");
//        Driver driver = (Driver) clazz.newInstance();
//        //注册驱动
//        DriverManager.registerDriver(driver);
        Class.forName("com.mysql.jdbc.Driver");
        //获取连接
        String url = "jdbc:mysql://localhost:3306/jiangcl?useUnicode=true&characterEncoding=utf-8";
        String userName = "root";
        String password = "root";
        Connection connection = DriverManager.getConnection(url, userName, password);
        System.out.println(connection);
    }

    /**
     * 通过配置文件获取连接
     */
    @Test
    public void test4() throws Exception {
        //获取配置文件
        InputStream in = ClassLoader.getSystemClassLoader().getResourceAsStream("db.properties");
        //InputStream in = ConnectionTest.class.getClassLoader().getResourceAsStream("db.properties");
        Properties properties = new Properties();
        properties.load(in);

        //获取配置文件中的属性值
        String driver = (String) properties.get("driver");
        String url = (String) properties.get("url");
        String userName = (String) properties.get("userName");
        String password = (String) properties.get("password");

        //加载驱动
        Class.forName(driver);

        //获取连接
        Connection connection = DriverManager.getConnection(url, userName, password);
        System.out.println(connection);
    }
}
