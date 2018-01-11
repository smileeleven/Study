package net.i2finance.socketTech;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketTech {
	public static void main(String[] args) throws IOException {
		System.out.println("我，服务器要启动啦，注意...");
		//1.创建一个固定端口服务
		ServerSocket ss=null;
		Socket s=null;
		try {
			ss = new ServerSocket(10003);
			//2.监听端口，等待客户端连接，并且连接后获取到客户端socket
			 s=ss.accept();
			//打印客户端的IP
			System.out.println(s.getInetAddress().getHostAddress()+"....has connnected");
			//3.获取客户端的数据
			InputStream in =s.getInputStream();
			byte[] buff =new byte[1024];
			int count =in.read();
			System.out.println(new String(buff,0,count));
		} catch (IOException e) {
			System.out.println();
		}finally{
			//4.关闭socket
			s.close();
			ss.close();
		}
	}
}
