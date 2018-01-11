package net.i2finance.socketTech;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class TechIO {
	public static void main(String[] args) throws IOException {
		BufferedReader buff =new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw =new PrintWriter(System.out);
		String line =null;
		while(true){
			if("over".equals(line)){
				break;
			}
			pw.println(line);
			pw.flush();
		}
		pw.close();
		
	}
}
