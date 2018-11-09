package com.util.threadPool;

import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TrackingThreadPool extends ThreadPoolExecutor {

	private final Map<Runnable, Boolean> inProgress = new ConcurrentHashMap<Runnable, Boolean>();

	private final ThreadLocal<Long> startTime = new ThreadLocal<Long>();

	private long totalTime;

	private int totalTask;

	public TrackingThreadPool(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit,
			BlockingQueue<Runnable> workQueue) {
		super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
	}

	@Override
	public void beforeExecute(Thread t, Runnable r) {
		super.beforeExecute(t, r);
		startTime.set(System.currentTimeMillis());
		inProgress.put(r, Boolean.TRUE);
	}

	@Override
	public void afterExecute(Runnable r, Throwable t) {
		long time = System.currentTimeMillis() - startTime.get();
		synchronized (this) {
			totalTime += time;
			++totalTask;
		}
		super.afterExecute(r, t);
		inProgress.remove(r);
	}

	public synchronized int getInProgressTaskAmount() {
		return inProgress.keySet().size();
	}

	public synchronized int getTotalTasks() {
		return totalTask;
	}

	public synchronized long getTotalTaskTime() {
		return totalTime;
	}

	public synchronized double getAverageTaskTime() {
		return totalTask == 0 ? 0 : totalTime / (double) totalTask;
	}

	public synchronized int getQueueSize() {
		return getQueue().size();
	}

}
