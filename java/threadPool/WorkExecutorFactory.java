package com.util.threadPool;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class WorkExecutorFactory {

	private static final WorkExecutorRepository wr = WorkExecutorRepository.getInstance();

	@SuppressWarnings({ "unused", "null" })
	private void initWorkExecutors() {
		List<WorkExecutorDTO> workExecutorDTOs = null;
		for (WorkExecutorDTO workExecutorDTO : workExecutorDTOs) {
			ThreadPoolExecutor exec = initThreadPool(workExecutorDTO);
			wr.bind(workExecutorDTO.getWorkExecutorName(), exec);
		}
	}

	private ThreadPoolExecutor initThreadPool(WorkExecutorDTO workExecutorDTO) {
		if (workExecutorDTO.getMaxWorkQueueSize() > 0) {
			return new TrackingThreadPool(workExecutorDTO.getCorePoolSize(), workExecutorDTO.getMaxPoolSize(), 0L,
					TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(workExecutorDTO.getMaxWorkQueueSize()));
		} else if (workExecutorDTO.getMaxWorkQueueSize() == 0) {
			return new TrackingThreadPool(0, workExecutorDTO.getMaxPoolSize(), 60L, TimeUnit.SECONDS,
					new SynchronousQueue<Runnable>());
		} else if (workExecutorDTO.getMaxWorkQueueSize() < 0) {
			return new TrackingThreadPool(0, workExecutorDTO.getMaxPoolSize(), 60L, TimeUnit.SECONDS,
					new LinkedBlockingQueue<Runnable>());
		} else {
			throw new IllegalArgumentException("无法创建此类型线程池: " + workExecutorDTO.getWorkExecutorName());
		}
	}

	public static ThreadPoolExecutor getWorkExecutor(String workExecutorName) {
		return wr.lookup(workExecutorName);
	}

}
