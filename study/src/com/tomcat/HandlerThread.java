package com.tomcat;

import java.io.*;
import java.net.Socket;

/**
 * @author aiboleepro
 * @date 2018-01-10 下午4:09
 **/
public class HandlerThread implements Runnable {
    private Socket socket;

    public HandlerThread(Socket client) {
        socket = client;
    }

    @Override
    public void run() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String line = reader.readLine();
            System.out.println(line);
            //请求资源路径
            String resource = line.substring(line.indexOf('/'), line.lastIndexOf('/') - 5);
            String root = "/Users/aiboleepro/apache-tomcat-7.0.82/webapps/docs";
            StringBuffer filePath = new StringBuffer(root);
            String _root = "/";
            if (_root.equals(resource)) {
                filePath.append("/index.html");
            } else {
                filePath.append(resource);
            }
            File fileToSend = new File(filePath.toString());
            PrintStream writer = new PrintStream(socket.getOutputStream());
            // 返回应答消息,并结束应答
            writer.println("HTTP/1.1 200 OK");
            // 根据 HTTP 协议, 空行将结束头信息
            writer.println();
            FileInputStream fis = new FileInputStream(fileToSend);
            byte[] buf = new byte[fis.available()];
            fis.read(buf);
            writer.write(buf);
            writer.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
