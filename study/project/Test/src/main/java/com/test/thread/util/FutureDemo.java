package com.test.thread.util;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class FutureDemo {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		testFuture();
	}

	public static void testFuture() throws InterruptedException, ExecutionException {
		ExecutorService executor = Executors.newFixedThreadPool(3);
		Calculater cal = new Calculater();
		FutureTask<Integer> futureTask = new FutureTask<>(cal);

		// Future<Integer> future = executor.submit(cal);
		// System.out.println(future.get());

		// executor.submit(futureTask);
		// System.out.println(futureTask.get());

//		Future<Integer> future = executor.submit(() -> {
//			try {
//				Thread.sleep(3000);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//			System.out.println("running......");
//		} , 100);
//		System.out.println(future.get());
		
		Future<Integer> future = executor.submit(futureTask, 100);
		System.out.println(future.get());
		System.out.println(futureTask.get());
		

		executor.shutdown();
	}

}

class Calculater implements Callable<Integer> {

	@Override
	public Integer call() throws Exception {
		int sum = 0;

		for (int i = 1; i <= 10; i++) {
			sum += i;
			Thread.sleep(200);
		}

		return sum;
	}

}
