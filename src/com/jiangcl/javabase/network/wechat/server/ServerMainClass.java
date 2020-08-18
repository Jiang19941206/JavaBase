package com.jiangcl.javabase.network.wechat.server;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author jiangcl
 * @date 2020/8/18
 * @desc
 */
public class ServerMainClass {

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(9090);
        System.out.println("服务端已启动");
        while (true){
            Socket socket = serverSocket.accept();
            System.out.println(socket.getInetAddress().getHostAddress() + "连接成功");
            ServerThread serverThread = new ServerThread(socket, null);
            Thread thread = new Thread(serverThread);
            thread.start();
        }
    }
}
