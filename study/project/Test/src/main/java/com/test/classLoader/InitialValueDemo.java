package com.test.classLoader;

public class InitialValueDemo {

	public static final String STR;
	
	static {
		STR = "";
	}
	
	public final String temp;
	
//	{
//		temp = "";
//	}
	
	public InitialValueDemo () {
		temp = "abc";
	}
	
	public static void main(String[] args) {
		InitialValueDemo instance = new InitialValueDemo();
		System.out.println(instance.temp);
	}
}
