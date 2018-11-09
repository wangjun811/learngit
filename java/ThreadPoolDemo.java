package com.test.demo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.AbortPolicy;
import java.util.concurrent.TimeUnit;

public class ThreadPoolDemo {

	public static void main(String[] args) throws InterruptedException {
		
	}
	
	public static void testWaiter() throws InterruptedException {
		ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 3, 0l, TimeUnit.SECONDS,
				new ArrayBlockingQueue<Runnable>(2), new AbortPolicy());
		executor.execute(new Waiter("Waiter1"));
		
		TimeUnit.MILLISECONDS.sleep(100);
		
		executor.execute(new Waiter("Waiter2"));
		
		TimeUnit.MILLISECONDS.sleep(100);
		
		executor.execute(new Waiter("Waiter3"));
		
		TimeUnit.MILLISECONDS.sleep(100);
		
		executor.execute(new Waiter("Waiter4"));
		
		TimeUnit.MILLISECONDS.sleep(100);
		
		executor.execute(new Waiter("Waiter5"));
		
		TimeUnit.MILLISECONDS.sleep(100);
		
		executor.shutdown();
	}
	
	public static class Waiter implements Runnable {
		
		private String name;
		
		public Waiter(String name){
			this.name = name;
		}
		
		@Override
		public void run() {
			System.out.println(this.name + " is running");
			
			try {
				TimeUnit.SECONDS.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.println(this.name + " is ending");
		}
	}
	
	public static void testExecutorCategory() {
		ExecutorService fixedExecutor = Executors.newFixedThreadPool(2);
		ExecutorService cachedExecutor = Executors.newCachedThreadPool();
		ExecutorService singleExecutor = Executors.newSingleThreadExecutor();
	}

	public static void testScheduleThreadPool() {
		ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);

		/**
		 * ScheduleAtFixedRate 每次执行时间为上一次任务开始起向后推一个时间间隔，即每次执行时间为 :initialDelay,
		 * initialDelay+period, initialDelay+2*period, …
		 */
		executor.scheduleAtFixedRate(new ThreadPoolDemo().new JobRunner("Runner1"), 2, 2, TimeUnit.SECONDS);

		/**
		 * ScheduleWithFixedDelay
		 * 每次执行时间为上一次任务结束起向后推一个时间间隔，即每次执行时间为：initialDelay,
		 * initialDelay+executeTime+delay, initialDelay+2*executeTime+2*delay
		 */
		executor.scheduleWithFixedDelay(new ThreadPoolDemo().new JobRunner("Runner2"), 5, 2, TimeUnit.SECONDS);

	}

	class JobRunner implements Runnable {

		private String name;

		public JobRunner(String name) {
			this.name = name;
		}

		@Override
		public void run() {
			System.out.println(name + " is running");
			try {
				TimeUnit.SECONDS.sleep(3);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(name + " is ending");
		}

	}

	/**
	 * ThreadPoolExecutor.AbortPolicy:丢弃任务并抛出RejectedExecutionException异常。
	 * ThreadPoolExecutor.DiscardPolicy：也是丢弃任务，但是不抛出异常。
	 * ThreadPoolExecutor.DiscardOldestPolicy：丢弃队列最前面的任务，然后重新尝试执行任务（重复此过程）
	 * ThreadPoolExecutor.CallerRunsPolicy：由调用线程处理该任务
	 */
	public static void testThreadPoolRejectPolicy() {
		ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 3, 0l, TimeUnit.SECONDS,
				new ArrayBlockingQueue<Runnable>(1), new AbortPolicy());
		executor.execute(new ThreadPoolDemo().new JobRunner("Runner1"));
		executor.execute(new ThreadPoolDemo().new JobRunner("Runner2"));
		executor.execute(new ThreadPoolDemo().new JobRunner("Runner3"));
		executor.execute(new ThreadPoolDemo().new JobRunner("Runner4"));
		new Thread() {
			@Override
			public void run() {
				executor.execute(new ThreadPoolDemo().new JobRunner("Runner5"));
			}
		}.start();

		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Add Runner again");

		executor.execute(new ThreadPoolDemo().new JobRunner("Runner6"));
		executor.execute(new ThreadPoolDemo().new JobRunner("Runner7"));

		executor.shutdown();
	}

	public static void testExecutorCompletionService() {
		int size = 3;
		ExecutorService pool = Executors.newFixedThreadPool(size);
		CompletionService<Boolean> cService = new ExecutorCompletionService<Boolean>(pool);

		for (int i = 1; i <= size; i++) {
			cService.submit(new ThreadPoolDemo().new Worker("Worker" + i));
		}

		for (int i = 1; i <= size; i++) {
			try {
				System.out.println(cService.take().get());
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}

		pool.shutdown();
	}

	public class Worker implements Callable<Boolean> {

		private String name;

		public Worker(String name) {
			this.name = name;
		}

		@Override
		public Boolean call() throws Exception {

			try {
				if (this.name.equals("Runner1")) {
					System.out.println(this.name + " start");

					Thread.sleep(3000);

					throw new Exception("Tester exception");

				} else if (this.name.equals("Runner2")) {
					Thread.sleep(5000);
				}

				System.out.println(this.name + " end");

				return true;
			} catch (Exception e) {
				return false;
			}
		}

	}
}
