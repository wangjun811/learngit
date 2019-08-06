package com.test.demo.cast;

public class Human {

	public String name = "Human";
	
	public String getName() {
		return this.name;
	}
	
	public static void main(String[] args) {
		Human h = new Male();
		System.out.println(h.name);
		System.out.println(h.getName());
	}
}
