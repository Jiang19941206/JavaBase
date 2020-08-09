package com.jiangcl.javabase.network.filecopy;

import java.io.*;
import java.net.Socket;

/** 文件复制客户端
 * @author jiangcl
 * @date 2020/7/29
 * @desc
 */
public class FileCopyClient {

    public static void main(String[] args) throws Exception {
        System.out.println("客户端启动");
        /**
         * 使用tcp协议进行文件传输
         */
        //创建文件输入流
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("D:\\FileDir\\source_dir\\a _1.xml")));
        //创建Socket对象
        Socket socket = new Socket("127.0.0.1", 10083);
        //获取socket输出流
        OutputStream out = socket.getOutputStream();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
        String line;
        //文件传输
        while ((line = br.readLine()) != null){
            bw.write(line);
            bw.newLine();
            bw.flush();
        }
        //注意：当文件传输结束后需要向服务端发送文件发送完成提醒
        socket.shutdownOutput();

        //接收服务端反馈
        InputStream in = socket.getInputStream();
        byte[] bs = new byte[1024];
        in.read(bs,0,bs.length);
        System.out.println(new String(bs));

        socket.close();
        br.close();
    }
}
