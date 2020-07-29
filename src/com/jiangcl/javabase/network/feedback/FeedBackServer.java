package com.jiangcl.javabase.network.feedback;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/** 当服务端接收到消息后，给客户端一个反馈
 * @author jiangcl
 * @date 2020/7/29
 * @desc
 */
public class FeedBackServer {

    public static void main(String[] args) throws Exception {
        System.out.println("启动服务端");
        //创建对象
        ServerSocket serverSocket = new ServerSocket(10081);
        /**
         * 接收消息
         */
        //获取客户端的套接字连接
        Socket socket = serverSocket.accept();
        InputStream in = socket.getInputStream();
        byte[] bs = new byte[1024];
        in.read(bs,0,bs.length);
        System.out.println("服务端接收到的数据为：" + new String(bs));

        /**
         * 向客户端反馈信息
         */
        //获取输出流
        OutputStream out = socket.getOutputStream();
        out.write("我已接收到消息。。。".getBytes());
        serverSocket.close();
    }
}
