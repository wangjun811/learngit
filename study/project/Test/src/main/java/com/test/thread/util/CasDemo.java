package com.test.thread.util;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class CasDemo {

	public static void main(String[] args) {
		CasDemo demo = new CasDemo();
		demo.testAtomicIntger();
	}

	public void testAtomicRef() {
		final AtomicReference<Integer> ref = new AtomicReference<>(new Integer(1000));
		List<Thread> list = new ArrayList<>();
		for (int i = 0; i < 1000; i++) {
			Thread thread = new Thread(() -> {
				for (;;) {
					Integer olfV = ref.get();
					if (ref.compareAndSet(olfV, olfV + 1)) {
						break;
					}
				}
			});
			list.add(thread);
			thread.start();
		}

		for (Thread thread : list) {
			try {
				thread.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		System.out.println(ref.get());
	}

	public void testAtomicIntger() {
		AtomicInteger inc = new AtomicInteger();
		for (int i = 0; i < 1000; i++) {
			new Thread(() -> {
				try {
					Thread.sleep(1);
				} catch (Exception e) {
					e.printStackTrace();
				}
				inc.incrementAndGet();
			}).start();
		}
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println(inc.get());
	}
	
}
