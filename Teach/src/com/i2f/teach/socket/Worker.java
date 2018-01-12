package com.i2f.teach.socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.Callable;

/**
 * @author ChenWei 2018-01-11 17:44
 **/
public abstract class Worker implements Callable<Map>{
  //公有属性或方法提出来

  public InputStream inputStream;
  public OutputStream outputStream;
  public Socket socket;
  public void init() throws IOException {

  }
  public  void getWriteBack() throws IOException {

  }
  public void sendStringMessages() throws FileNotFoundException, IOException {

  }
  public void sendFileMessages() throws IOException {

  }

  public void close() throws IOException {

  }
}
