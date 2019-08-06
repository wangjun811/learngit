package com.test.exception;

public class MyExceptionTest {

	public static void main(String[] args) throws Exception {
		try {
			if (1 == 1) {
				throw new MyException("“Ï≥£¡À...");
			}
		} catch (MyException e) {
			throw new Exception(e);
		}

	}
}
