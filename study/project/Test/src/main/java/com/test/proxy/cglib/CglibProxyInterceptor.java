package com.test.proxy.cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CglibProxyInterceptor implements MethodInterceptor {

	/**
	 * sub:cglib生成的代理对象,method:被代理对象方法,objects:方法入参,methodProxy:代理方法
	 */
	@Override
	public Object intercept(Object sub, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
		System.out.println("执行前...");
		Object retVal = methodProxy.invokeSuper(sub, objects);
		System.out.println("执行后...");
		return retVal;
	}

}
