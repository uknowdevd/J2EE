package com.sparc.concurrency;


public class Counter {

	private int counter = 0;
	private static final Counter instance = new Counter();

	private Counter()
	{
		
	}
	
	public static Counter getInstance()
	{
		return instance;
	}
	
	public int incrementCounter()
	{
		return counter++;
	}
	
	public int getCount()
	{
		return counter;
	}
}
