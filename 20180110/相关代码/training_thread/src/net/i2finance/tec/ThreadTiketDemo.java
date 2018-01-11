package net.i2finance.tec;

public class ThreadTiketDemo extends Thread{
	//有100张票分四个窗口去买
	private int num =100;
	Object o =new Object();
	public void run(){
		while(true){
			synchronized (o) {
				sale();
			}
		}
	}
	private void sale() {
		if(num>0){
			System.out.println(Thread.currentThread().getName()+"num:"+ num--);
		}
	}
}
