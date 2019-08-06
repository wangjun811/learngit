package com.test.classLoader;

public class LoaderTest {

	public static void main(String[] args) throws ClassNotFoundException {
		ClassLoader loader = LoaderTest.class.getClassLoader();
		loader.loadClass("com.test.classLoader.Test2");
		Class.forName("com.test.classLoader.Test2");
	}
}
