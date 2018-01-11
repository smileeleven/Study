package com.i2f.teach.socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Map;
import java.util.concurrent.Callable;

/**
 * @author ChenWei 2018-01-11 17:47
 **/
public class WorkerA extends Worker implements Callable<Map> {

  @Override
  public Map call() throws Exception {
    this.init();
    String line = "test";
    bufferedWriter.write(line);
    //bufferedWriter.newLine();
    bufferedWriter.flush();
    socket.shutdownOutput();
    //接收服务端返回的数据
    String str = bufferedReader.readLine();
    System.out.println(str);
    bufferedReader.close();
    socket.close();
    return null;
  }
  private void init() throws IOException {
    this.socket=ClientSocketUtil.getSocket();
    this.bufferedReader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
    this.bufferedWriter=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
  }
}
