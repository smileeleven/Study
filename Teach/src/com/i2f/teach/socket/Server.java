package com.i2f.teach.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author ChenWei 2018-01-11 17:26
 **/
public class Server {

  public static void main(String[] args) throws IOException {
    ServerSocket serverSocket=new ServerSocket(9999);
    while (true){
      Socket socket = serverSocket.accept();
      new ServerExecutor(socket);
    }
  }
}
