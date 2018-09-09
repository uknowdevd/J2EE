package com.sparc.concurrency;

public class MyRunnable implements Runnable{

	@Override
	public void run() {

		System.out.println("Inside run of thread" + Thread.currentThread().getName());
	}
	

}
