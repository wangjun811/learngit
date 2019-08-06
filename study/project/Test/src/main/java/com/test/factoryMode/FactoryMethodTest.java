package com.test.factoryMode;

public class FactoryMethodTest {

	static void print(Coffee[] coffees) {
		for(Coffee coffee : coffees) {
			System.out.println(coffee.getName());
		}
	}
	
	public static void main(String[] args) {
		CoffeeFactory chinaCoffeeFactory = new ChinaCoffeeFactory();
		Coffee[] chinaCoffees = chinaCoffeeFactory.createCoffee();
		System.out.println("�й����ȹ��������Ŀ����У�");
		print(chinaCoffees);
		
		CoffeeFactory americaCoffeeFactory = new AmericaCoffeeFactory();
		Coffee[] americaCoffees = americaCoffeeFactory.createCoffee();
		System.out.println("�������ȹ��������Ŀ����У�");
		print(americaCoffees);
	}
}
