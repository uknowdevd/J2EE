package com.sparc.concurrency;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Example for ThreadPool - Executor service
 * @author dheeru
 *
 */
public class Application3 {
	
	
	@SuppressWarnings("unchecked")
	public static void main (String[] args)
	{
		ExecutorService threadService = Executors.newFixedThreadPool(10);
		ExecutorService asyncThreadService = Executors.newFixedThreadPool(10);
		ExecutorService callableThreadService = Executors.newCachedThreadPool();
		
		
		int i = 0;
		//Typical synchronous thread example
		for( i = 0; i< 100 ; i++)
		{
			threadService.execute(new Runnable()
		{
			
			public void run()
			{
				System.out.println(" Thread " + Thread.currentThread().getName()) ;
			}
		});
		}
		
		
		int j = 0;
		//Typical asynchronous future example
		for( j = 0; j< 100 ; j++)
		{
			Future future = threadService.submit(new Runnable()
		{
			
			public void run()
			{
				System.out.println("Async Thread " + Thread.currentThread().getName()) ;
			}
			
		});
			
			
			try {
				if(future.get() == null)
				{
					System.out.println("Work is complete" + future);
				}
				else
				{
					System.out.println("Work is not complete" + future);
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		
		for(int k=0; k<100; k++)
		{
			Callable cb = new MyCallable();
		Future ft = callableThreadService.submit(cb);
		try {
			System.out.println(ft.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
		threadService.shutdown();
		asyncThreadService.shutdown();
		callableThreadService.shutdown();
	}

}
