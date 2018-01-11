package com.i2f.teach.socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.Callable;

/**
 * @author ChenWei 2018-01-11 17:44
 **/
public abstract class Worker implements Callable<Map>{
  //公有属性或方法提出来

  public BufferedReader bufferedReader;
  public BufferedWriter bufferedWriter;
  public Socket socket;
}
