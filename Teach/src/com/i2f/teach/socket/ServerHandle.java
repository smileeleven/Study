package com.i2f.teach.socket;

import com.i2f.teach.FileUtil;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.Callable;

/**
 * @author ChenWei 2018-01-11 17:30
 **/
public class ServerHandle implements Callable<Map> {
  private Socket socket;
  private InputStream inputStream;
  private OutputStream outputStream;
  public ServerHandle(Socket socket) throws IOException {
    this.socket=socket;
    this.inputStream=socket.getInputStream();
    this.outputStream=socket.getOutputStream();
  }
  @Override
  public Map call() throws Exception {
    //接收文件类型数据
    this.getStringMessages();
    //返回数据
    this.writeBack();
    //关闭连接
    this.close();
    return null;
  }
  private void close() throws IOException {
    this.inputStream.close();
    this.outputStream.close();
    this.socket.close();
  }
  //获取字符串类型数据
  public void getStringMessages() throws IOException {
    byte[]  bytes=new byte[1024];
    int len=0;
    String message="";
    while((len=this.inputStream.read(bytes))!=-1)
    {
      message+=new String(bytes,0,len);
    }
    System.out.println("客户端发送："+new Date()+"=>"+message);
  }
  //获取文件类型数据
  public void getFileMessages() throws IOException {
    //将读取的数据存储到指定文件中
    //1.创建文件file
    //文件存储路径，相对路径
    String filePath="src/bizhi2.jpg";
    File file=new File(filePath);
    //2.判断是否存在
    FileUtil.isFileExistsAndDelete(file);
    //3.新建文件
    file.createNewFile();
    //4.存储文件
    this.storeFile(file);
  }

  //向客户端返回数据
  void writeBack() throws IOException {
    this.outputStream.write("传输完成".getBytes());
  }
  //将文件存储到某个路径
  void storeFile(File file) throws IOException {
    FileOutputStream fileOutputStream = new FileOutputStream(file);
    String line = null;
    byte[]  bytes=new byte[1024];
    int len=0;
    while((len=this.inputStream.read(bytes))!=-1)
    {
      fileOutputStream.write(bytes,0,len);
    }
    fileOutputStream.flush();
    fileOutputStream.close();
  }

}
