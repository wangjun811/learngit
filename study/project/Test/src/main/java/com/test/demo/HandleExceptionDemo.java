package com.test.demo;

public class HandleExceptionDemo {

	public static void main(String[] args) throws Exception {
		HandleExceptionDemo demo = new HandleExceptionDemo();
		int result = demo.test1();
		System.out.println(result);
	}

	public int test1() throws Exception {
		int i;
		try {
			i = 2 / 0;
			return i;
		} catch (Exception e) {
//			throw new Exception(e);
			return 6;
		} finally {
			System.out.println("finally...");
			return 2;
		}
	}
}
