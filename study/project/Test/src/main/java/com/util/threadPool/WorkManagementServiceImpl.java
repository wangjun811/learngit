package com.util.threadPool;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class WorkManagementServiceImpl implements WorkManagementService {

	@Override
	public void submitWork(String workExecutorName, Runnable task) {
		ExecutorService exec = WorkExecutorFactory.getWorkExecutor(workExecutorName);
		if (exec == null) {
			throw new NullPointerException("指定的工作执行队列不存在，队列名：" + workExecutorName);
		}
		exec.execute(task);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Future submitFutureWork(String workExecutorName, Callable<?> task) {
		ExecutorService exec = WorkExecutorFactory.getWorkExecutor(workExecutorName);
		if (exec == null) {
			throw new NullPointerException("指定的工作执行队列不存在，队列名：" + workExecutorName);
		}
		return exec.submit(task);
	}

	@Override
	public TrackingThreadPool getCurrentThreadPool(String threadPoolName) {
		return (TrackingThreadPool) WorkExecutorFactory.getWorkExecutor(threadPoolName);
	}

	@Override
	public Long getCurrentThreadPoolTotalExecuteTime(String threadPoolName) {
		return getCurrentThreadPool(threadPoolName).getTotalTaskTime();
	}

	@Override
	public Long getCurrentThreadPoolAverageExecuteTime(String threadPoolName) {
		return (long) getCurrentThreadPool(threadPoolName).getAverageTaskTime();
	}

	@Override
	public Integer getCurrentThreadPoolTotalExecuteTaskNum(String threadPoolName) {
		return getCurrentThreadPool(threadPoolName).getTotalTasks();
	}

	@Override
	public Integer getCurrentThreadPoolTotalSuccessfullyExecuteTaskNum(String threadPoolName) {
		return getCurrentThreadPool(threadPoolName).getTotalTasks()
				- getCurrentThreadPool(threadPoolName).getActiveCount();
	}

}
