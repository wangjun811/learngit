package com.util.threadPool;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadPoolExecutor;

public class WorkExecutorRepository {

	private final ConcurrentHashMap<String, ThreadPoolExecutor> executors;
	
	private WorkExecutorRepository() {
		executors = new ConcurrentHashMap<String, ThreadPoolExecutor>();
	}
	
	private static class SingletonHandler {
		static final WorkExecutorRepository INSTANCE = new WorkExecutorRepository();
	}
	
	public static WorkExecutorRepository getInstance() {
		return SingletonHandler.INSTANCE;
	}
	
	public ThreadPoolExecutor lookup(String workExecutorName) {
		return executors.get(workExecutorName);
	}
	
	public ThreadPoolExecutor bind(String workExecutorName, ThreadPoolExecutor exec) {
		return executors.putIfAbsent(workExecutorName, exec);
	}
	
	public ThreadPoolExecutor unBind(String worExecutorName) {
		return executors.remove(worExecutorName);
	}
}
