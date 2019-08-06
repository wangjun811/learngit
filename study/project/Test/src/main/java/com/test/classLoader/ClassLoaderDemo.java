package com.test.classLoader;

import java.lang.reflect.Method;

public class ClassLoaderDemo {

	public static void main(String[] args) throws Exception {
		testMyClassLoader();
	}

	public static void printClassLoader() {
		System.out.println(ClassLoaderDemo.class.getClassLoader());

		System.out.println(ClassLoaderDemo.class.getClassLoader().getParent());

		System.out.println(ClassLoaderDemo.class.getClassLoader().getParent().getParent());
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void testMyClassLoader() throws Exception {
		// 自定义类加载器的加载路径
		MyClassLoader myClassLoader = new MyClassLoader();
		myClassLoader.setRoot("E:\\Test");
		// 包名+类名
		Class c = myClassLoader.loadClass("com.test.classLoader.Test");
		
		if (c != null) {
			Object obj = c.newInstance();
			Method method = c.getMethod("say", null);
			method.invoke(obj, null);
			System.out.println(c.getClassLoader().toString());
		}
	}
}
