package com.jiangcl.javabase.network.wechat.server;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

/**
 * @author jiangcl
 * @date 2020/8/18
 * @desc
 */
public class ServerMainClass {
    private static Map<String,Socket> socketMap = new HashMap<>();

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(9090);

        System.out.println("服务端已启动");
        while (true){
            Socket socket = serverSocket.accept();
            System.out.println(socket.getInetAddress().getHostAddress() + ":" + socket.getPort() + " 连接成功");

            //将信息反馈给客户端
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bw.write(socket.getInetAddress().getHostAddress() + ":" + socket.getPort());
            bw.flush();
            bw.newLine();
            socket.shutdownOutput();
            socketMap.put(socket.getInetAddress().getHostAddress() + ":" + socket.getPort(),socket);
            ServerThread serverThread = new ServerThread(socket, socketMap);
            Thread thread = new Thread(serverThread);
            thread.start();
        }
    }
}
