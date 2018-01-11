package net.i2finance.Thread;

public class TestThreadCreate extends Thread{
   private int num =100;
   public void run(){
	   while(true){
		   if(num >0){
			   System.out.println(Thread.currentThread().getName()+"sale."+num--);
		   }
	   }
   }
}

