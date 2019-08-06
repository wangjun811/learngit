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
			throw new IllegalArgumentException("type[" + type + "]类型不可识别，没有匹配到可实例化的对象!");
		}
	}

	public static void main(String[] args) {
		Coffee latte = SimpleFactory.createInstance("Latte");
		System.out.println("创建的咖啡实例为：" + latte.getName());

		Coffee cappuccino = SimpleFactory.createInstance("Cappuccino");
		System.out.println("创建的咖啡实例为：" + cappuccino.getName());
	}
}
