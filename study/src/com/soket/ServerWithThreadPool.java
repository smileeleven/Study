package com.soket;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author aiboleepro
 * @date 2018-01-10 下午6:38
 **/
public class ServerWithThreadPool {

    // 监听的端口号
    private static final int PORT = 8080;
    // 创建了线程池
    private static ExecutorService executorService = Executors.newFixedThreadPool(50);

    private void init(){
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            while (true) {
                // 一旦有堵塞, 则表示服务器与客户端获得了连接
                Socket client = serverSocket.accept();
                // 处理这次连接
                executorService.submit(new DealSocket(client));
//                executorService.shutdown();
            }
        } catch (Exception e) {
            System.out.println("服务器异常: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        System.out.println("服务器启动...\n");
        ServerWithThreadPool server = new ServerWithThreadPool();
        server.init();
    }

}
