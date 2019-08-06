package com.test.factoryMode;

public class AmericaCoffeeFactory extends CoffeeFactory {

	@Override
	public Coffee[] createCoffee() {
		return new Coffee[] { new Americano(), new Latte() };
	}

}
