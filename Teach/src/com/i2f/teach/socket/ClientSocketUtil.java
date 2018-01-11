package com.i2f.teach.socket;

import java.io.IOException;
import java.net.Socket;

/**
 * @author ChenWei 2018-01-11 17:42
 **/
public class ClientSocketUtil {
  private static  Socket socket;
  public static Socket getSocket() throws IOException {
    socket=new Socket("127.0.0.1",9999);
    return socket;
  }
}
