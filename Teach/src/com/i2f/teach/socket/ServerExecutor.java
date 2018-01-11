package com.i2f.teach.socket;

import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author ChenWei 2018-01-11 17:28
 **/
public class ServerExecutor {
  private static ExecutorService executorService= Executors.newCachedThreadPool();
  private Socket socket=null;
  public ServerExecutor (Socket socket) throws IOException {
    this.socket=socket;
    this.handle();
  }
  private void handle() throws IOException {
    executorService.submit(new ServerHandle(socket));
  }
}
