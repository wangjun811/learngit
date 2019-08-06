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
		// �Զ�����������ļ���·��
		MyClassLoader myClassLoader = new MyClassLoader();
		myClassLoader.setRoot("E:\\Test");
		// ����+����
		Class c = myClassLoader.loadClass("com.test.classLoader.Test");
		
		if (c != null) {
			Object obj = c.newInstance();
			Method method = c.getMethod("say", null);
			method.invoke(obj, null);
			System.out.println(c.getClassLoader().toString());
		}
	}
}
