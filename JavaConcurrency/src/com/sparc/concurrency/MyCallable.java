package com.sparc.concurrency;

import java.util.concurrent.Callable;

public class MyCallable implements Callable{

	@Override
	public Object call() throws Exception {
		System.out.println("Async Callable " + Thread.currentThread().getName());
		return "Yes it matches - Thread info " + Thread.currentThread().getName();
		
		
	}

}
