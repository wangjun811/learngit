package com.test.demo;

public class ThisDemo {

	public static void main(String[] args) {
		ThisDemo demo = new ThisDemo();
		demo.test();
	}
	
	public void test() {
		new Animal().invoke();
	}
}

class Animal {
	
	
	public void invoke() {
		Fruit f = new Fruit(this, "animal");
		f.printResource();
	}
}

class Fruit {
	
	private String name;
	
	private Object resource;
	
	public Fruit(Object resource, String name) {
		this.resource = resource;
		this.name = name;
	}
	
	public void printResource() {
		System.out.println(resource);
	}
}
