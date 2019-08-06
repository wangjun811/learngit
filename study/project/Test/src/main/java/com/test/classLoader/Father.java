package com.test.classLoader;

public class Father {

	public static String fatherStr = "fatherStr";
	
	static {
		System.out.println("Father");
	}
}
