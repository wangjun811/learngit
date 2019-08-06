package com.test.demo.thread;

public class ThreadInterruptDemo {

	public static void main(String[] args) throws InterruptedException {
		MyThread mt = new MyThread();
		mt.start();
		Thread.sleep(1000);
//		System.out.println("sleep1 end");
		mt.interrupt();
//		Thread.sleep(2000);
//		System.out.println("sleep2 end");
//		mt.interrupt();
	}
	
	public static void test() {
		
	}
}

class MyThread extends Thread{
	
	@Override
	public void run() {
		
		while(true) {
//			if(Thread.currentThread().isInterrupted()){
//                System.out.println("Yes,I am interruted,but I am still running");
// 
//            }else{
//                System.out.println("not yet interrupted");
//            }
			System.out.println(this.isInterrupted());
			
			try {
				Thread.sleep(2500);
			} catch (InterruptedException e) {
				System.out.println("1" + this.isInterrupted());
				Thread.currentThread().interrupt();
				System.out.println(this.isInterrupted());
				break;
			}
		}
		
	}
}

