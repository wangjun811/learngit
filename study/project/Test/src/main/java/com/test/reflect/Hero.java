package com.test.reflect;

public class Hero {

	public String name;
	
	public float hp;
	
	public float armor;
	
	public int moveSpeed;
	
	Hero(String str) {
		System.out.println("(Ĭ��)�Ĺ��췽�� s = " + str);
	}
	
	public Hero() {
		System.out.println("�����˹��С��޲ι��췽��");
	}
	
	public Hero(char name) {
		System.out.println("������" + name);
	}
	
	public Hero(String name, float hp) {
		System.out.println("������" + name + ", Ѫ����" + hp);
	}
	
	protected Hero(boolean n) {
		System.out.println("�ܱ����Ĺ��췽�� n = " + n);
	}
	
	private Hero(float hp) {
		System.out.println("˽�еĹ��췽����Ѫ����" + hp);
	}
}
