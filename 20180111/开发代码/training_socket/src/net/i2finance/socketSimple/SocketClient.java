package net.i2finance.socketSimple;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketClient {
	public static void main(String[] args) throws UnknownHostException, IOException {
		System.out.println("客户端要启动啦。。。。。");
		Socket s =new Socket("127.0.0.1",1003);
		OutputStream o =s.getOutputStream();
		o.write("hhahahh".getBytes());
		s.close();
	}
}
