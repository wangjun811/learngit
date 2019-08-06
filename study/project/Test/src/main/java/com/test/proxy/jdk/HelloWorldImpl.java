package com.test.proxy.jdk;

public class HelloWorldImpl implements HelloWorld {

	@Override
	public void sayHello(String name) {
		System.out.println("Hello " + name);
	}

	@Override
	public void sayHi(String name) {
		System.out.println("Hi " + name);
	}

}
