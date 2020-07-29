package com.jiangcl.javabase.network.keyboard;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/** 服务端
 * @author jiangcl
 * @date 2020/7/29
 * @desc
 */
public class KeyServer {

    public static void main(String[] args) throws Exception {
        System.out.println("服务端启动");
        /**
         * 接收客户端发送的数据
         */
        //创建ServerSocket
        ServerSocket serverSocket = new ServerSocket(10082);
        //获取客户端的套接字连接
        Socket socket = serverSocket.accept();
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String line;
        while ((line = br.readLine()) != null){
            System.out.println(line);
        }
        serverSocket.close();
    }
}
