package com.test.factoryMode;

public class AbstractFactoryTest {

	static void print(Drink drink) {
		if (drink == null) {
			System.out.println("��Ʒ��--");
		} else {
			System.out.println("��Ʒ��" + drink.getName());
		}
	}

	public static void main(String[] args) {
		AbstractDrinksFactory chinaDrinksFactory = new ChinaDrinksFactory();
		Coffee coffee = chinaDrinksFactory.createCoffee();
		Tea tea = chinaDrinksFactory.createTea();
		Sodas sodas = chinaDrinksFactory.createSodas();
		System.out.println("�й���Ʒ���������²�Ʒ��");
		print(coffee);
		print(tea);
		print(sodas);

		AbstractDrinksFactory americaDrinksFactory = new AmericaDrinksFactory();
		coffee = americaDrinksFactory.createCoffee();
		tea = americaDrinksFactory.createTea();
		sodas = americaDrinksFactory.createSodas();
		System.out.println("������Ʒ���������²�Ʒ��");
		print(coffee);
		print(tea);
		print(sodas);
	}

}
