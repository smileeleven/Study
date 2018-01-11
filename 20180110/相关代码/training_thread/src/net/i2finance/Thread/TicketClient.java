package net.i2finance.Thread;

class TicketClient{
	public static void main(String[] args) {
		/*TestThreadCreate t1 =new TestThreadCreate();
		TestThreadCreate t2 =new TestThreadCreate();
		TestThreadCreate t3 =new TestThreadCreate();
		TestThreadCreate t4 =new TestThreadCreate();
		t1.start();
		t2.start();
		t3.start();
		t4.start();*/
		TestRunnableCreate t =new TestRunnableCreate();
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