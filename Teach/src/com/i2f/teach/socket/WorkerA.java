package com.i2f.teach.socket;

import com.i2f.teach.FileUtil;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.Callable;

/**
 * @author ChenWei 2018-01-11 17:47
 **/
public class WorkerA extends Worker implements Callable<Map> {

  @Override
  public Map call() throws Exception {
    //初始化
    this.init();
    //发送数据
    this.sendStringMessages();
    //接收返回数据
    this.getWriteBack();
    return null;
  }
  @Override
  public void init() throws IOException {
    this.socket=ClientSocketUtil.getSocket();
    this.inputStream=socket.getInputStream();
    this.outputStream=socket.getOutputStream();
  }
  //接收服务端返回
  @Override
  public void getWriteBack() throws IOException {
    byte[] bytes=new byte[1024];
    int len=0;
    String message="";
    while ((len=inputStream.read(bytes))!=-1){
      message+=new String(bytes,0,len);
    }
    System.out.println("服务端返回："+new Date()+"=>"+message);
  }
  //发送字符串数据
  @Override
  public void sendStringMessages() throws IOException {
    String message="message";
    outputStream.write(message.getBytes());
    socket.shutdownOutput();
  }
  //发送文件类型数据
  @Override
  public void sendFileMessages() throws IOException {
    String filePath="src/bizhi1.jpg";
    File file=new File(filePath);
    FileUtil.isFileExists(file);
    FileInputStream fileInputStream=new FileInputStream(file);
    byte[] bytes=new byte[1024];
    int len=0;
    while((len=fileInputStream.read(bytes))!=-1)
    {
      outputStream.write(bytes,0,len);
    }
    socket.shutdownOutput();
  }

  @Override
  public void close() throws IOException {
    outputStream.close();
    inputStream.close();
    socket.close();
  }
}
