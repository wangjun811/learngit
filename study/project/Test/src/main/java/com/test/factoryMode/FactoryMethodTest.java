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
		System.out.println("中国咖啡工厂生产的咖啡有：");
		print(chinaCoffees);
		
		CoffeeFactory americaCoffeeFactory = new AmericaCoffeeFactory();
		Coffee[] americaCoffees = americaCoffeeFactory.createCoffee();
		System.out.println("美国咖啡工厂生产的咖啡有：");
		print(americaCoffees);
	}
}
