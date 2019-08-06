package com.test.factoryMode;

public class SimpleFactory {

	public static Coffee createInstance(String type) {
		if ("Americano".equals(type)) {
			return new Americano();
		} else if ("Cappuccino".equals(type)) {
			return new Cappuccino();
		} else if ("Latte".equals(type)) {
			return new Latte();
		} else {
			throw new IllegalArgumentException("type[" + type + "]���Ͳ���ʶ��û��ƥ�䵽��ʵ�����Ķ���!");
		}
	}

	public static void main(String[] args) {
		Coffee latte = SimpleFactory.createInstance("Latte");
		System.out.println("�����Ŀ���ʵ��Ϊ��" + latte.getName());

		Coffee cappuccino = SimpleFactory.createInstance("Cappuccino");
		System.out.println("�����Ŀ���ʵ��Ϊ��" + cappuccino.getName());
	}
}
