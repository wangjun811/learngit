package com.test.thread.util;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;

public class Account {

	private AtomicLong balance;

	public Account(Long money) {
		balance = new AtomicLong(money);
		System.out.println("Total Money:" + money);
	}

	public void withDraw(long money) {
		for (;;) {
			long oldValue = balance.get();
			if (oldValue < money) {
				System.out.println(Thread.currentThread().getName() + " 余额不足！余额：" + oldValue);
				break;
			}

			// 模拟取款时间
			try {
				Thread.sleep(new Random().nextInt(1000));
			} catch (Exception e) {
			}

			if (balance.compareAndSet(oldValue, oldValue - money)) {
				System.out.println(Thread.currentThread().getName() + " 取款 " + money + " 成功！ 余额：" + balance);
				break;
			}

			System.out.println(Thread.currentThread().getName() + " 遇到并发，再次尝试取款！");
		}
	}

	public static void main(String[] args) {
		final Account account = new Account(1000L);
		ExecutorService executor = Executors.newCachedThreadPool();
		int i = 0;
		while (i++ < 13) {
			executor.execute(() -> {
				account.withDraw(100L);
			});
		}
	}

}
