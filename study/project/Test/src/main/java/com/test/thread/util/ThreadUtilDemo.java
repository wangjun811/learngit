package com.test.thread.util;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class ThreadUtilDemo {

	public static void main(String[] args) throws InterruptedException {
		ThreadUtilDemo demo = new ThreadUtilDemo();
		demo.testSemaphore();
	}

	/**
	 * CountDownLatch类似于计数器的方式，用于等待一个或多个线程执行完操作开始自身代码的执行
	 * 
	 * @throws InterruptedException
	 */
	public void testCountDownLatch() throws InterruptedException {
		final CountDownLatch latch = new CountDownLatch(2);

		new Thread(() -> {
			System.out.println("thread1 start...");
			try {
				Thread.sleep(5000);
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("thread1 end...");
			latch.countDown();
		}).start();

		new Thread(() -> {
			System.out.println("thread2 start...");
			System.out.println("thread2 end...");
			latch.countDown();
		}).start();

		latch.await();
		System.out.println("main thread end...");
	}

	/**
	 * CyclicBarrier即同步屏障，它主要功能是让一组线程达到一个屏障（也可以称为同步点）是被阻塞，直到最后一个线程达到屏障时，屏障才被打开，
	 * 所有被拦截的线程才会继续执行
	 * 
	 * @throws InterruptedException
	 */
	public void testCyclicBarrier() throws InterruptedException {
		CyclicBarrier barrier = new CyclicBarrier(2, () -> {
			System.out.println("等待的线程已结束，运行当前线程");
		});

		new Thread(() -> {
			System.out.println("thread1 start...");

			try {
				Thread.sleep(3000);
			} catch (Exception e) {
				e.printStackTrace();
			}

			System.out.println("thread1 end, wait other threads end...");
			try {
				barrier.await();
			} catch (Exception e) {
				e.printStackTrace();
			}

			System.out.println("all threads end...");
		}).start();

		new Thread(() -> {
			System.out.println("thread2 start...");

			System.out.println("thread2 end, wait other threads end...");

			try {
				barrier.await();
			} catch (Exception e) {
				e.printStackTrace();
			}

			System.out.println("all threads end...");
		}).start();
	}

	/**
	 * Semaphore即信号量，主要用来控制并发访问特定资源的线程数量，协调各个线程合理使用公共资源
	 */
	public void testSemaphore() {
		Semaphore semaphore = new Semaphore(2);

		new Thread(() -> {
			try {
				semaphore.acquire();
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("thread1 use resource...");

			try {
				Thread.sleep(3000);
			} catch (Exception e) {
				e.printStackTrace();
			}

			System.out.println("thread1 release resource...");

			semaphore.release();
		}).start();

		new Thread(() -> {
			try {
				semaphore.acquire();
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("thread2 use resource...");

			try {
				Thread.sleep(3000);
			} catch (Exception e) {
				e.printStackTrace();
			}

			System.out.println("thread2 release resource...");

			semaphore.release();
		}).start();

		new Thread(() -> {
			try {
				semaphore.acquire();
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("thread3 use resource...");

			try {
				Thread.sleep(3000);
			} catch (Exception e) {
				e.printStackTrace();
			}

			System.out.println("thread3 release resource...");

			semaphore.release();
		}).start();
	}
}
