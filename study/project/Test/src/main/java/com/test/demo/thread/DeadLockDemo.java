package com.test.demo.thread;

import java.util.concurrent.TimeUnit;

public class DeadLockDemo {

	public static void main(String[] args) {
		DeadLockDemo demo = new DeadLockDemo();
		demo.testDeadLock();
	}
	
	private static String source1 = "source1";
	
	private static String source2 = "source2";
	
	public void testDeadLock() {
		Thread t1 = new Thread(){
			@Override
			public void run(){
				synchronized(source1){
					System.out.println(Thread.currentThread().getName() + " is Running fisrt");
					try {
						TimeUnit.MILLISECONDS.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					synchronized(source2){
						System.out.println(Thread.currentThread().getName() + " is Running second");
					}
				}
			}
		};
		t1.setName("Thread1");
		t1.start();
		
		
		Thread t2 = new Thread(){
			@Override
			public void run(){
				synchronized(source2){
					System.out.println(Thread.currentThread().getName() + " is Running fisrt");
					try {
						TimeUnit.MILLISECONDS.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					synchronized(source1){
						System.out.println(Thread.currentThread().getName() + " is Running second");
					}
				}
			}
		};
		t2.setName("Thread2");
		t2.start();
	}
	
}
