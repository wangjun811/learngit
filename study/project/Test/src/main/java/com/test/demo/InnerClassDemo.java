package com.test.demo;

public class InnerClassDemo {

	public String name;

	public InnerClassDemo() {

	}

	public InnerClassDemo(String name) {
		this.name = name;
	}

	public class Inner {

		public String name;

		public Inner() {

		}

		public Inner(String name) {
			this.name = name;
		}

		public void eat() {
			System.out.println("Inner eat()");
		}

		public void test() {
			this.eat();
			InnerClassDemo.this.eat();
		}
	}

	public void eat() {
		System.out.println("Outer eat()");
	}

	public static void main(String[] args) {
		InnerClassDemo outer = new InnerClassDemo("outer");
		Inner inner = outer.new Inner("inner");
		inner.test();
	}
}
