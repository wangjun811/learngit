package com.test.factoryMode;

public class AmericaDrinksFactory implements AbstractDrinksFactory {

	@Override
	public Coffee createCoffee() {
		return new Latte();
	}

	@Override
	public Tea createTea() {
		return new AmericaTea();
	}

	@Override
	public Sodas createSodas() {
		return new CocaCola();
	}

}
