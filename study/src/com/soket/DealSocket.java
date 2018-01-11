package com.soket;

import com.xml.XmlUtil;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Map;

/**
 * 处理接受的socket请求
 *
 * @author aiboleepro
 * @date 2018-01-10 下午6:42
 **/
public class DealSocket implements Runnable {

    private Socket socket;

    public DealSocket(Socket socket){
        Thread.currentThread().setName(socket.getLocalAddress().getHostName());
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // 读取客户端数据
            DataInputStream input = new DataInputStream(socket.getInputStream());
            //这里要注意和客户端输出流的写方法对应,否则会抛 EOFException
            String clientInputStr = input.readUTF();
            // 处理客户端数据
            System.out.println("客户端发过来的内容:" + clientInputStr);
            Map<String,String> map = XmlUtil.parseParam(clientInputStr);
            System.out.println(map);
            String money = XmlUtil.parseBank(map.get("bankId"),map.get("userId"));
            // 向客户端回复信息
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            out.writeUTF(money);
            out.close();
            input.close();
        } catch (Exception e) {
            System.out.println("服务器 run 异常: " + e.getMessage());
        } finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (Exception e) {
                    socket = null;
                    System.out.println("服务端 finally 异常:" + e.getMessage());
                }
            }
        }
    }
}
