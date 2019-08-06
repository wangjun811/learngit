package com.test.extend;

public class OverloadDemo {

	public static void main(String[] args) {
		OverloadDemo demo = new OverloadDemo();
		demo.test();
	}

	public void test() {
		eat((Apple) null);
	}

	public void eat(Apple apple) {
		System.out.println("eat apple");
	}

	public void eat(Orange orange) {
		System.out.println("eat orange");
	}

	class Fruit {

	}

	class Apple extends Fruit {

	}

	class Orange {

	}
}
