package net.i2finance.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class TestIO {
	public static void main(String[] args) throws IOException {
		BufferedReader in =new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw =new PrintWriter(System.out);
		String line =null;
		while((line =in.readLine()) !=null){
			pw.println(line);
			pw.flush();
		}
		pw.close();
	}
}
