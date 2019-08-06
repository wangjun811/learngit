package com.test.demo;

class A {
	
	public String name = "A";
	
	public void show() {
		System.out.println("Class A show() function");
	}
	
}

class B extends A {
	
	public String name = "B";
	
	public void show() {
		System.out.println("Class B show() function");
	}
	
	public void eat() {
		System.out.println("A eat");
	}
}

public class TestCast {

	public static void main(String[] args) {

//		TestCast cls = new TestCast();
//		Class c = cls.getClass();
//		System.out.println(c);
//
//		Object obj = new A();
//		B b1 = new B();
//		b1.show();
//
//		// casts object
//		A a = new A();
//		a = A.class.cast(b1);
//
//		System.out.println(obj.getClass());
//		System.out.println(b1.getClass());
//		System.out.println(a.getClass());
//		a.show();
		
		
		A a = new B();
		System.out.println(a.name);
		System.out.println(((B)a).name);
	}
}