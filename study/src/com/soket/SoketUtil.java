package com.soket;

import com.bean.BankParam;
import com.bean.BankResult;
import com.util.JaxbUtil;

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

    public static BankResult request(BankParam bankParam){
        Socket socket = null;
        try{
            socket = new Socket(IP_ADDR, PORT);
            // 向服务器端发送数据
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            String params = JaxbUtil.convertToXml(bankParam);
            out.writeUTF(params);
            // 读取服务器端数据
            DataInputStream input = new DataInputStream(socket.getInputStream());
            String result = input.readUTF();
            out.close();
            input.close();
            return JaxbUtil.convertToJavaBean(result,BankResult.class);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }finally {
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