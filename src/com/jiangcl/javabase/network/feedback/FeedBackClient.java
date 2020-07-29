package com.jiangcl.javabase.network.feedback;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/** 客户端
 * @author jiangcl
 * @date 2020/7/29
 * @desc
 */
public class FeedBackClient {

    public static void main(String[] args) throws Exception {
        System.out.println("启动客户端");
        //创建Socket对象
        Socket socket = new Socket("127.0.0.1", 10081);
        /**
         * 发送消息
         */
        //获取输出流
        OutputStream out = socket.getOutputStream();
        out.write("this is china".getBytes());

        /**
         * 接收反馈
         */
        //获取输入流
        InputStream in = socket.getInputStream();
        byte[] bs = new byte[1024];
        in.read(bs,0,bs.length);
        System.out.println("客户端接收到的信息是：" + new String(bs));

        socket.close();
    }
}
