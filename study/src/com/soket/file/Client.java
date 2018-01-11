package com.soket.file;

import java.io.*;
import java.net.Socket;

/**
 * @author aiboleepro
 * @date 2018-01-11 下午4:07
 **/
public class Client {
    //服务器地址
    private static final String IP_ADDR = "localhost";
    //服务器端口号
    private static final int PORT = 8080;

    public static void main(String[] args) {
        System.out.println("客户端启动...");
        Socket socket = null;
        try {
            socket = new Socket(IP_ADDR, PORT);
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            File file = new File("/Users/aiboleepro/IdeaProjects/Study/study/src/com/xml/bank.xml");
            FileInputStream inputStream = new FileInputStream(file);
            out.writeUTF("bank2.xml");
            byte[] bytes = new byte[1024];
            while( inputStream.read(bytes, 0, bytes.length)  > 0){
                out.write(bytes,0, bytes.length);
                out.flush();
            }
            inputStream.close();
            out.close();
        } catch (Exception e) {
            System.out.println("客户端异常:" + e.getMessage());
        } finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    System.out.println("客户端 finally 异常:" + e.getMessage());
                }
            }
        }
    }
}