package com.test.lambda;

public class LambdaThisDemo {

	public static void main(String[] args) {
		LambdaThisDemo demo = new LambdaThisDemo();
		demo.test();
	}
	
	public void test() {
		Runnable runnable = () -> {
			System.out.println(this.toString());
		};
		
		new Thread(runnable).start();
	}
	
	public String toString() {
		return "LambdaThisDemo.class";
	}
}
