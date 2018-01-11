package net.i2finance.socketSimple;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {
	public static void main(String[] args) throws IOException {
		System.out.println("服务端启动了");
		ServerSocket server =new ServerSocket(1003);
		Socket s =server.accept();
		System.out.println(s.getInetAddress().getHostAddress()+"....connection");
		InputStream in =s.getInputStream();
		byte[] buff =new byte[1024];
		int len =in.read(buff);
		System.out.println(new String(buff,0,len));
		s.close();
		server.close();
	}
}
