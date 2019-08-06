package com.test.classLoader;

public class Son extends Father {

	public static String sonStr = "sonStr";
	
	static {
		System.out.println("Son");
	}
}

