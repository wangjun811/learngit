package com.test.thread.util;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang.math.RandomUtils;

public class CompletionServiceDemo {

	private static final int TASK_NUM = 20;

	private static Callable<String> createCallableTask(String str) {
		return () -> {
			int time = RandomUtils.nextInt(1000);
			TimeUnit.MILLISECONDS.sleep(time);
			System.out.println("Finished: " + Thread.currentThread().getName() + "time=" + time);
			return str;
		};
	}

	private static void doAnotherJob() throws InterruptedException {
		TimeUnit.MILLISECONDS.sleep(1000);
	}

	public static void main(String[] args) throws InterruptedException {
		ThreadPoolExecutor executor = new ThreadPoolExecutor(4, 8, 20L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(),
				new ThreadPoolExecutor.AbortPolicy());

		CompletionService<String> getStringService = new ExecutorCompletionService<>(executor);

		for (int i = 0; i <= TASK_NUM; i++) {
			getStringService.submit(createCallableTask("Hello =>" + i));
		}

		doAnotherJob();

		try {
			for (int i = 0; i <= TASK_NUM; i++) {
				Future<String> future = getStringService.take();
				String result = future.get();
				System.out.println(result);
			}
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}

		System.out.println(executor);
		executor.shutdown();
	}
}
