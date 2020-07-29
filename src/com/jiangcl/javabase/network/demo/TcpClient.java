package com.jiangcl.javabase.network.demo;

import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

/** 客户端
 * @author jiangcl
 * @date 2020/7/29
 * @desc
 */
public class TcpClient {

    public static void main(String[] args) throws Exception {
        /**
         * TCP发送数据
         * 1、创建客户端Socket对象
         * 2、获取输出流传输数据
         * 3、关闭资源
         */
        System.out.println("客户端启动");
        Socket socket = new Socket("127.0.0.1", 10086);
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("this is china".getBytes());
        socket.close();
    }
}
