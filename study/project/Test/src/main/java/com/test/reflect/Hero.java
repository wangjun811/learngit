package com.test.reflect;

public class Hero {

	public String name;
	
	public float hp;
	
	public float armor;
	
	public int moveSpeed;
	
	Hero(String str) {
		System.out.println("(默认)的构造方法 s = " + str);
	}
	
	public Hero() {
		System.out.println("调用了公有、无参构造方法");
	}
	
	public Hero(char name) {
		System.out.println("姓名：" + name);
	}
	
	public Hero(String name, float hp) {
		System.out.println("姓名：" + name + ", 血量：" + hp);
	}
	
	protected Hero(boolean n) {
		System.out.println("受保护的构造方法 n = " + n);
	}
	
	private Hero(float hp) {
		System.out.println("私有的构造方法，血量：" + hp);
	}
}
