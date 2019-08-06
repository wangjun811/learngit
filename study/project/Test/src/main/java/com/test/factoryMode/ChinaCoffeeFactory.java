package com.test.factoryMode;

public class ChinaCoffeeFactory extends CoffeeFactory {

	@Override
	public Coffee[] createCoffee() {
		return new Coffee[] { new Cappuccino(), new Latte() };
	}

}
