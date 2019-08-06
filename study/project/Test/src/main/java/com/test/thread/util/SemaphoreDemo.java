package com.test.thread.util;

import java.util.concurrent.Semaphore;

public class SemaphoreDemo {

}

class Pool {

	private static final int MAX_AVAILABLE = 100;

	private Semaphore available = new Semaphore(MAX_AVAILABLE);

	protected Object[] items = new Object[MAX_AVAILABLE];

	protected boolean[] used = new boolean[MAX_AVAILABLE];

	public Object getItem() throws InterruptedException {
		available.acquire();
		return getNextAvailableItem();
	}

	public synchronized Object getNextAvailableItem() {
		for (int i = 0; i < MAX_AVAILABLE; i++) {
			if (!used[i]) {
				used[i] = true;
				return items[i];
			}
		}
		return null;
	}

	public void releaseItem(Object item) throws InterruptedException {
		if (markAsUnused(item)) {
			available.release();
		}
	}

	public synchronized boolean markAsUnused(Object item) {
		for (int i = 0; i < MAX_AVAILABLE; i++) {
			if (item == items[i]) {
				if (used[i]) {
					used[i] = false;
					return true;
				} else {
					return false;
				}
			}
		}

		return false;
	}
}
