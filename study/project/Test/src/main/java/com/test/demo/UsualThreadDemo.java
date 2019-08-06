package com.test.demo;

public class UsualThreadDemo {

	public static void main(String[] args) {
		System.out.println("main start...");
		
		new Thread() {
			@Override
			public void run() {
				System.out.println(this.getName() + " start...");
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(this.getName() + " end...");
			}
		}.start();
		
		System.out.println("main end...");
	}
}
