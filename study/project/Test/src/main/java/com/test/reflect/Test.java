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

		System.out.println("**********************���й��й��췽��*********************************");

		Constructor[] conArray = clazz.getConstructors();
		for (Constructor c : conArray) {
			System.out.println(c);
		}

		System.out.println("************���еĹ��췽��(������˽�С��ܱ�����Ĭ�ϡ�����)***************");

		conArray = clazz.getDeclaredConstructors();
		for (Constructor c : conArray) {
			System.out.println(c);
		}

		System.out.println("*****************��ȡ���С��޲εĹ��췽��*******************************");

		Constructor con = clazz.getConstructor(null);
		System.out.println("con =" + con);
		Object obj = con.newInstance();

		System.out.println("******************��ȡ˽�й��췽����������*******************************");

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
	 * �������ڱ����ڼ������õġ��ڱ�����.class�ļ�����û�з��͵ģ����б���T����E���ͣ����ʶ���ͨ��Object����ģ�
	 * ���Կ���ͨ��ʹ�÷���Խ������
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
