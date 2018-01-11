package com.soket.chat;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author aiboleepro
 * @date 2018-01-10 下午3:39
 **/
public class Server {
    //监听的端口号
    private static final int PORT = 8080;

    private void init() {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            while (true) {
                // 一旦有堵塞, 则表示服务器与客户端获得了连接
                Socket client = serverSocket.accept();
                // 处理这次连接
                new Thread(new HandlerThread(client)).start();
            }
        } catch (Exception e) {
            System.out.println("服务器异常: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        System.out.println("服务器启动...\n");
        Server server = new Server();
        server.init();
    }

}