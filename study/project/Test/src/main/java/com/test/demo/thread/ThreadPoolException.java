package com.test.demo.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolException {

	public static void main(String[] args) {
		final ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 3, 2, TimeUnit.SECONDS,
				new ArrayBlockingQueue<Runnable>(2));
		
		new Thread () {
			@Override
			public void run() {
				try {
					Thread.sleep(6000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				executor.execute(new Runner("Inner Thread"));
			}
		}.start();
		
		for (int i = 1; i < 7; i++) {
			executor.execute(new Runner("Thread" + i));
		}
		
		System.out.println("Main is ending");
		executor.shutdown();
	}

}

class Runner implements Runnable {

	String name;

	public Runner(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		System.out.println(this.name + " is starting...");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(this.name + " is ending...");
	}
}
