package com.test.exception;

public class MyExceptionTest {

	public static void main(String[] args) throws Exception {
		try {
			if (1 == 1) {
				throw new MyException("�쳣��...");
			}
		} catch (MyException e) {
			throw new Exception(e);
		}

	}
}
