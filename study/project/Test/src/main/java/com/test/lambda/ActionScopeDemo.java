package com.test.lambda;

public class ActionScopeDemo {

	public static void main(String[] args) {
		
	}
	
	String email = "";
	
	public void testLambdaScope(String name, int count) {
		int age = 0;
		
		new Thread(() -> {
//			System.out.println(age);
			email = "";
		});
		
		age = 2;
	}
}
