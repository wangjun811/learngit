package com.test.demo.thread;

public class InterruptDemo {

	public static void main(String[] args) {
		InterruptDemo demo = new InterruptDemo();
		demo.testInterrupt();
	}
	
	public void testInterrupt() {
		MyThread myThread = new MyThread();
		myThread.start();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		myThread.interrupt();
	}
	
	class MyThread extends Thread {
		
		@Override
		public void run() {
			System.out.println("MyThread is running");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				System.out.println("MyThread is interrupted");
			}
			System.out.println("MyThread is ending");
		}
	}
}
