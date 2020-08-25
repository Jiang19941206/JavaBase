package com.jiangcl.javabase.network.wechat.client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * @author jiangcl
 * @date 2020/8/19
 * @desc
 */
public class ClientTwo {

    public static void main(String[] args) throws Exception {
        System.out.println("client two 启动");
        /**
         * 通过键盘录入向服务端发送数据
         *
         */
        //创建socket对象
        Socket socket = new Socket("localhost", 9090);
        //获取服务器的返回信息
        BufferedReader sBr = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String sLine = sBr.readLine();

        List<String> keyList = new ArrayList<>();
        System.out.println(keyList.size());

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
        bw.close();
        br.close();
        sBr.close();
        socket.close();
    }
}
