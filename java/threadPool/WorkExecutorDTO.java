package com.util.threadPool;

public class WorkExecutorDTO {

	private String workExecutorName;

	private int maxWorkQueueSize;

	private int corePoolSize;

	private int maxPoolSize;

	public String getWorkExecutorName() {
		return workExecutorName;
	}

	public void setWorkExecutorName(String workExecutorName) {
		this.workExecutorName = workExecutorName;
	}

	public int getMaxWorkQueueSize() {
		return maxWorkQueueSize;
	}

	public void setMaxWorkQueueSize(int maxWorkQueueSize) {
		this.maxWorkQueueSize = maxWorkQueueSize;
	}

	public int getCorePoolSize() {
		return corePoolSize;
	}

	public void setCorePoolSize(int corePoolSize) {
		this.corePoolSize = corePoolSize;
	}

	public int getMaxPoolSize() {
		return maxPoolSize;
	}

	public void setMaxPoolSize(int maxPoolSize) {
		this.maxPoolSize = maxPoolSize;
	}

}
