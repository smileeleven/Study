package net.i2finance.socketTech;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketClientTech {	
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket clent =new Socket("127.0.0.1", 10003);
		OutputStream o =clent.getOutputStream();
		o.write("∏Á£¨Œ“¿¥¿≤".getBytes());
		clent.close();
	}
}
