package com.soket;

import java.io.*;
import java.net.Socket;

/**
 * @author aiboleepro
 * @date 2018-01-10 下午7:07
 **/
public class SoketUtil {

    //服务器地址
    private static final String IP_ADDR = "localhost";
    //服务器端口号
    private static final int PORT = 8080;

    private static Socket socket;

    public static String request(String params){
        String ret = null;
        while (true) {
            Socket socket = null;
            try {
                //创建一个流套接字并将其连接到指定主机上的指定端口号
                socket = new Socket(IP_ADDR, PORT);
                //向服务器端发送数据
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                out.writeUTF(params);
                //读取服务器端数据
                DataInputStream input = new DataInputStream(socket.getInputStream());
                ret = input.readUTF();
                System.out.println("服务器端返回过来的是: " + ret);
                // 这里需要处理超时，如果长时间没有拿到结果，应该错误处理
                if(!ret.equals("")){
                    break;
                }
                out.close();
                input.close();
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
        return ret;
    }



}
