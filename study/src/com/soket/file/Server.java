package com.soket.file;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author aiboleepro
 * @date 2018-01-11 下午4:07
 **/
public class Server {
    //监听的端口号
    private static final int PORT = 8080;

    private void init() {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            while (true) {
                Socket client = serverSocket.accept();
                deal(client);
            }
        } catch (Exception e) {
            System.out.println("服务器异常: " + e.getMessage());
        }
    }

    private void deal(Socket socket) throws IOException {
        DataInputStream input = new DataInputStream(socket.getInputStream());
        FileOutputStream fileOutputStream = new FileOutputStream(new File("/Users/aiboleepro/IdeaProjects/Study/study/src/com/xml/" + input.readUTF()));
        byte[] bytes = new byte[1024];
        while (input.read(bytes, 0, bytes.length) > 0) {
            fileOutputStream.write(bytes,0, bytes.length);
            fileOutputStream.flush();
        }
        fileOutputStream.close();
    }

    public static void main(String[] args) {
        System.out.println("服务器启动...\n");
        Server server = new Server();
        server.init();
    }

}
