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
public class ClientOne {

    public static void main(String[] args) throws Exception {
        System.out.println("client one 启动");
        /**
         * 通过键盘录入向服务端发送数据
         *
         */
        //创建socket对象
        Socket socket = new Socket("127.0.0.1", 9090);
        //获取服务器的返回信息
        BufferedReader sBr = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String sLine = sBr.readLine();
        List<String> keyList = new ArrayList<>();
        System.out.println(keyList.size());
        if(keyList != null && keyList.size() > 0){
            System.out.println("请选择目标客户端：");
            for (String key : keyList) {
                if(!sLine.equals(key)){
                    System.out.println(key);
                }
            }
            BufferedReader targetBr = new BufferedReader(new InputStreamReader(System.in));
            String targetLine;
            while ((targetLine = targetBr.readLine()) != null) {
                if(keyList.contains(targetLine)){
                    break;
                }
                if(targetLine.equals(sLine)){
                    System.out.println("不能选择自己。。。");
                }
                System.out.println("请选择正确的客户端。。。");
            }
            targetBr.close();
            System.out.println(targetLine);
        }

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
