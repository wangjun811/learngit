package com.test.thread.util;

import java.util.concurrent.CountDownLatch;

public class Test {

	public static void main(String[] args) throws InterruptedException {
		CountDownLatch latch = new CountDownLatch(1);

		new Thread(() -> {
			try {
				Thread.sleep(2000);
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("thread1 end......");
		}).start();

		new Thread(() -> {
			System.out.println("thread2 end......");
		}).start();

		Runtime.getRuntime().addShutdownHook(new Thread(() -> {
			System.out.println("shutdown end......");
			latch.countDown();
		}));

//		latch.await();

		System.out.println("main end......");
		
		try {
			
			Thread.sleep(3000);
			System.out.println(1/0);
			System.out.println("try end......");
		} catch(Exception e) {
			System.out.println("exception end......");
			System.exit(-1);
		}
		
		System.exit(0);
	}
}
