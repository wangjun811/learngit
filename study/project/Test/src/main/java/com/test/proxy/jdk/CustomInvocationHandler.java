package com.test.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class CustomInvocationHandler implements InvocationHandler {

	private Object target;
	
	public CustomInvocationHandler(Object target) {
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("Before invocation");
		Object retVal = method.invoke(target, args);
		System.out.println(retVal);
		System.out.println("After invocation");
		return retVal;
	}
}
