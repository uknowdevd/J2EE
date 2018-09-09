package com.sparc.concurrency;

public class CounterRunnable implements Runnable{
	
   Counter counter;
   
	@Override
	public void run() {

		synchronized(counter)
		{
		counter.incrementCounter();
		}
	}
	
	 public void setCounter(Counter counter)
	{
		this.counter = counter;
	}
	
}
