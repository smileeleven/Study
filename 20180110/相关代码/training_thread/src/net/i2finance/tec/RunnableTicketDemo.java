package net.i2finance.tec;

public class RunnableTicketDemo implements Runnable, sale{
	private int num =100;
	Object o =new Object();
	@Override
	public void run() {
		/*while(true){
			synchronized (o) {
				sale();
			}
		}*/
		sale();
	}
	private synchronized void sale() {
		if(num>0){
			/*try {
				Thread.currentThread().sleep(1000);
			} catch (InterruptedException e) {
				System.out.println("");
			}*/
			System.out.println(Thread.currentThread().getName()+"num:"+ num--);
		}
	}
}
