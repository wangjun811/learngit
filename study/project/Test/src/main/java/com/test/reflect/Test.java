package com.test.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class Test {

	public static void main(String[] args) throws Exception {
		System.out.println(Math.max(1, 0));
		
		
		Test test = new Test();
		test.genericityTest();
	}

	public void constructorTest() throws Exception {
		Class clazz = Class.forName("com.test.reflect.Hero");

		System.out.println("**********************所有公有构造方法*********************************");

		Constructor[] conArray = clazz.getConstructors();
		for (Constructor c : conArray) {
			System.out.println(c);
		}

		System.out.println("************所有的构造方法(包括：私有、受保护、默认、公有)***************");

		conArray = clazz.getDeclaredConstructors();
		for (Constructor c : conArray) {
			System.out.println(c);
		}

		System.out.println("*****************获取公有、无参的构造方法*******************************");

		Constructor con = clazz.getConstructor(null);
		System.out.println("con =" + con);
		Object obj = con.newInstance();

		System.out.println("******************获取私有构造方法，并调用*******************************");

		con = clazz.getDeclaredConstructor(float.class);
		System.out.println("con = " + con);
		con.setAccessible(true);
		obj = con.newInstance(100);
	}

	public void fieldTest() throws Exception {
		Class clazz = Class.forName("com.test.reflect.HeroPlus");
		Object obj = clazz.newInstance();
		Field f = clazz.getDeclaredField("name");
		f.setAccessible(true);
		f.set(obj, "instance");
		System.out.println(((HeroPlus) obj).getName());
	}

	public void methodTest() throws Exception {
		Class clazz = Class.forName("com.test.reflect.HeroPlus");
		Object obj = clazz.newInstance();
		Method m = clazz.getMethod("setName", String.class);
		m.invoke(obj, "instance");
		System.out.println(((HeroPlus) obj).getName());
	}

	public void mainMethodTest() throws Exception {
		Class clazz = Class.forName("com.test.reflect.HeroPlus");
		Method mainMethod = clazz.getMethod("main", String[].class);
		mainMethod.invoke(null, (Object) new String[] { "abc" });
	}

	/**
	 * 泛型是在编译期间起作用的。在编译后的.class文件中是没有泛型的，所有比如T或者E类型，本质都是通过Object处理的，
	 * 所以可以通过使用反射越过泛型
	 * 
	 * @throws Exception
	 */
	public void genericityTest() throws Exception {
		ArrayList<String> list = new ArrayList<>();
		list.add("this");
		list.add("is");

		Class listClass = list.getClass();
		Method m = listClass.getMethod("add", Object.class);
		m.invoke(list, 123);

		for (Object obj : list) {
			System.out.println(obj);
		}
	}
}
