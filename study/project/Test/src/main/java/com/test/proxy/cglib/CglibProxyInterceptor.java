package com.test.proxy.cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CglibProxyInterceptor implements MethodInterceptor {

	/**
	 * sub:cglib���ɵĴ������,method:��������󷽷�,objects:�������,methodProxy:������
	 */
	@Override
	public Object intercept(Object sub, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
		System.out.println("ִ��ǰ...");
		Object retVal = methodProxy.invokeSuper(sub, objects);
		System.out.println("ִ�к�...");
		return retVal;
	}

}
