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
	 * CountDownLatch�����ڼ������ķ�ʽ�����ڵȴ�һ�������߳�ִ���������ʼ��������ִ��
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
	 * CyclicBarrier��ͬ�����ϣ�����Ҫ��������һ���̴߳ﵽһ�����ϣ�Ҳ���Գ�Ϊͬ���㣩�Ǳ�������ֱ�����һ���̴߳ﵽ����ʱ�����ϲű��򿪣�
	 * ���б����ص��̲߳Ż����ִ��
	 * 
	 * @throws InterruptedException
	 */
	public void testCyclicBarrier() throws InterruptedException {
		CyclicBarrier barrier = new CyclicBarrier(2, () -> {
			System.out.println("�ȴ����߳��ѽ��������е�ǰ�߳�");
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
	 * Semaphore���ź�������Ҫ�������Ʋ��������ض���Դ���߳�������Э�������̺߳���ʹ�ù�����Դ
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
