package com.test.demo.thread;

public class SimulateFuture {

	public static void main(String[] args) {
		final FutureData<String> future = new FutureData<>();
		new Thread() {
			@Override
			public void run() {
				future.setResult(new RealData<String>("abc"));
			}
		}.start();
		System.out.println("waiting for result:" + future.getResult());
	}
}

interface Data<T> {

	T getResult();
}

class RealData<T> implements Data<T> {

	T result;

	public RealData(T result) {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.result = result;
	}

	@Override
	public T getResult() {
		return result;
	}

}

class FutureData<T> implements Data<T> {

	RealData<T> realData;

	boolean isReady;

	public synchronized void setResult(RealData<T> realData) {
		if (isReady) {
			return;
		}
		this.realData = realData;
		isReady = true;
		this.notifyAll();
	}

	@Override
	public synchronized T getResult() {
		if (!isReady) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return realData.getResult();
	}

}
