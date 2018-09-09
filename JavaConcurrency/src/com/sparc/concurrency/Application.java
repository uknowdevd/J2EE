package com.sparc.concurrency;

public class Application {
	
	
	public static void main (String[] args)
	{
		Runnable runable = new MyRunnable();
		for(int i = 0; i< 50 ; i++)
		{
	    Thread thread = new Thread(runable);

		thread.setName("Thread " + i);
		thread.start();
		try {
			thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		}
		
	}

}
