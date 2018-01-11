package com.i2f.teach.socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.Callable;
import jdk.net.Sockets;

/**
 * @author ChenWei 2018-01-11 17:30
 **/
public class ServerHandle implements Callable<Map> {
  private Socket socket;
  private BufferedWriter bufferedWriter;
  private BufferedReader bufferedReader;
  public ServerHandle(Socket socket) throws IOException {
    this.socket=socket;
    this.bufferedReader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
    this.bufferedWriter=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
  }
  @Override
  public Map call() throws Exception {
    byte[] bytes=new byte[1024];
    String line="";
    String readLine="";
    while ((line=this.bufferedReader.readLine())!=null){
      readLine+=line;
    }
    //此处进行请求类型判断
    if (true){
      this.bufferedWriter.write("0");
      //this.bufferedWriter.newLine();
      this.bufferedWriter.flush();
    }
    this.close();
    return null;
  }
  private void close() throws IOException {
    this.bufferedWriter.close();
    this.bufferedReader.close();
    this.socket.close();
  }
}
