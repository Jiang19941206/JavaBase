package com.jiangcl.javabase.network.filecopy;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/** 文件复制服务端
 * @author jiangcl
 * @date 2020/7/29
 * @desc
 */
public class FileCopyServer {

    public static void main(String[] args) throws Exception {
        System.out.println("服务端启动");
        /**
         * 服务端进行文件接收
         */
        //创建文件输出流
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("D:\\FileDir\\target_dir\\a _copy_1.xml")));
        //创建ServerSocket对象
        ServerSocket serverSocket = new ServerSocket(10083);
        //获取客户端socket连接
        Socket socket = serverSocket.accept();
        //获取socket输入流
        InputStream in = socket.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(in));

        String line;
        while ((line = br.readLine()) != null){
            bw.write(line);
            bw.newLine();
            bw.flush();
        }

        //文件接收成功后将信息反馈给客户端
        OutputStream out = socket.getOutputStream();
        out.write("文件接收成功".getBytes());

        System.out.println("文件接收成功");
        serverSocket.close();
        bw.close();
    }
}
