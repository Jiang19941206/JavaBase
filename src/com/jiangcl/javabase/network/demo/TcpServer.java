package com.jiangcl.javabase.network.demo;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/** 服务器
 * @author jiangcl
 * @date 2020/7/29
 * @desc
 */
public class TcpServer {
    public static void main(String[] args) throws Exception {
        /**
         * TCP接收数据
         * 1、创建服务器端Socket对象(ServerSocket)
         * 2、获取连接的客户端，并通过输入流获取数据
         * 3、关闭资源
         */
        System.out.println("服务端启动");
        ServerSocket serverSocket = new ServerSocket(10086);

        //监听客户端连接
        Socket socket = serverSocket.accept();
        int port = socket.getPort();
        System.out.println(port);
        //获取输入流
        InputStream in = socket.getInputStream();
        byte[] bs = new byte[1024];
        in.read(bs,0,bs.length);
        System.out.println(new String(bs));

        socket.close();
        serverSocket.close();
    }
}
