package com.test.demo;

public class IntegerDemo {

	public static void main(String[] args) {
		System.out.println(System.currentTimeMillis());
		System.out.println(Integer.valueOf(Long.valueOf(System.currentTimeMillis()).intValue()));
	}
}
