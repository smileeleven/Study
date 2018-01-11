package net.i2finance.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketClient {
	public static void main(String[] args) throws UnknownHostException, IOException {
		System.out.println("客户端要启动了...");
		Socket socket =new Socket("127.0.0.1",5500);
		//socket.getInputStream();
		OutputStream o =socket.getOutputStream();
		o.write("ewrewrewreewr".getBytes());
		InputStream in =socket.getInputStream();
		byte[] buff =new byte[1024];
		int count =in.read(buff);
		System.out.println(new String(buff, 0, count));
		socket.close();
	}
}
