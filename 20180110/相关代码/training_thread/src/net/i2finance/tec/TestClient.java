package net.i2finance.tec;

import net.i2finance.Thread.TestRunnableCreate;

public class TestClient {
	public static void main(String[] args) {
		/*ThreadTiketDemo t1 =new ThreadTiketDemo();
		ThreadTiketDemo t2 =new ThreadTiketDemo();
		ThreadTiketDemo t3 =new ThreadTiketDemo();
		ThreadTiketDemo t4 =new ThreadTiketDemo();
		t1.start();  
		t2.start();  
		t3.start();  
		t4.start();    */
		
		
		RunnableTicketDemo t =new RunnableTicketDemo();
		Thread t1 =new Thread(t);
		Thread t2 =new Thread(t);
		Thread t3 =new Thread(t);
		Thread t4 =new Thread(t);
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}
