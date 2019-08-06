package com.test.thread.util;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class AtomicRefTest {
	public static void main(String[] args) throws InterruptedException {
		AtomicReference<Integer> ref = new AtomicReference<>(new Integer(1000));

		List<Thread> list = new ArrayList<>();
		for (int i = 0; i < 1000; i++) {
			Thread t = new Thread(new Task(ref), "Thread-" + i);
			list.add(t);
			t.start();
		}

		for (Thread t : list) {
			t.join();
		}

		System.out.println(ref.get()); // ��ӡ2000
	}

}

class Task implements Runnable {
	private AtomicReference<Integer> ref;

	Task(AtomicReference<Integer> ref) {
		this.ref = ref;
	}

	@Override
    public void run() {
        for (; ; ) {    //��������
            Integer oldV = ref.get();   
            if (ref.compareAndSet(oldV, oldV + 1))  // CAS���� 
                break;
        }
    }
}