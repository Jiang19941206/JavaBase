package com.jiangcl.javabase.network.keyboard;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

/** 客户端
 * @author jiangcl
 * @date 2020/7/29
 * @desc
 */
public class KeyClient {

    public static void main(String[] args) throws Exception {
        System.out.println("客户端启动");
        /**
         * 通过键盘录入向服务端发送数据
         *
         */
        //创建socket对象
        Socket socket = new Socket("127.0.0.1", 10082);
        //获取键盘输入
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //创建一个字符输出流
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        String line;
        while ((line = br.readLine()) != null){
            if("886".equals(line)){
                break;
            }
            System.out.println(line);
            bw.write(line);
            bw.newLine();
            bw.flush();
        }
        br.close();
        socket.close();
    }
}
