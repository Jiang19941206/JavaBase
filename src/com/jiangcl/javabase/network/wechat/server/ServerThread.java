package com.jiangcl.javabase.network.wechat.server;

import com.alibaba.fastjson.JSONObject;
import com.jiangcl.javabase.network.wechat.entity.Message;

import java.io.*;
import java.net.Socket;
import java.util.Map;

/**
 * @author jiangcl
 * @date 2020/8/18
 * @desc
 */
public class ServerThread implements Runnable {
    private Socket socket;

    private Map<String,Socket> map;

    public ServerThread(Socket socket,Map<String,Socket> map) {
        this.socket = socket;
        this.map = map;
    }

    @Override
    public void run() {
        try {
            InputStream in = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            while (true) {

                String line = br.readLine();
                if(line == null){
                    socket.close();
                    break;
                }
                System.out.println(line);
                /*Message message = JSONObject.parseObject(line, Message.class);
                Socket targetSocket = map.get(message.getUserId());
                if(targetSocket.isConnected()){
                    OutputStream out = targetSocket.getOutputStream();
                    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
                    bw.write(message.getMsg());
                    bw.flush();
                }*/
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
