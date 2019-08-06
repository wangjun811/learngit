package com.util.threadPool;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;

public interface WorkManagementService {

	public void submitWork(String workExecutorName, Runnable task);

	public Future submitFutureWork(String workExecutorName, Callable<?> task);

	public TrackingThreadPool getCurrentThreadPool(String threadPoolName);

	public Long getCurrentThreadPoolTotalExecuteTime(String threadPoolName);

	public Long getCurrentThreadPoolAverageExecuteTime(String threadPoolName);

	public Integer getCurrentThreadPoolTotalExecuteTaskNum(String threadPoolName);

	public Integer getCurrentThreadPoolTotalSuccessfullyExecuteTaskNum(String threadPoolName);

}
