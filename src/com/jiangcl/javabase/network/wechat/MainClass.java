package com.jiangcl.javabase.network.wechat;

import com.jiangcl.javabase.network.wechat.server.ServerThread;
import org.junit.Test;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author jiangcl
 * @date 2020/8/18
 * @desc
 */
public class MainClass {

    public static void main(String[] args) throws Exception {
        System.out.println("客户端启动");
        /**
         * 通过键盘录入向服务端发送数据
         *
         */
        //创建socket对象
        Socket socket = new Socket("127.0.0.1", 9090);
        //获取键盘输入
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //创建一个字符输出流
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        String line;
        while ((line = br.readLine()) != null){
            if("886".equals(line)){
                break;
            }
            bw.write(line);
            bw.newLine();
            bw.flush();
        }
        br.close();
        socket.close();
    }
}
