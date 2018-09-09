package com.sparc.concurrency;

public class Application2 {
	
	
	public static void main(String[] args)
	{
		Counter counter = null;
		
		for(int i = 0; i< 50000 ; i++)
		{		
		//Creating singleton so that multiple threads are accessing same instance of that class
		counter =  Counter.getInstance();
		CounterRunnable runable = new CounterRunnable();
		runable.setCounter(counter);	
			 
			 System.out.println("Counter instance" + counter);

		
	    Thread thread = new Thread(runable);
		thread.setName("Thread " + i);
		thread.start();
		}
		
		
		System.out.println("Printing counter value " + counter.getCount());
		System.out.println("Counter instace "  + counter);
		
	}

}
