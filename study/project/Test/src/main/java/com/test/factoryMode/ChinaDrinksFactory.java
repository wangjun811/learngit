package com.test.factoryMode;

public class ChinaDrinksFactory implements AbstractDrinksFactory {

	@Override
	public Coffee createCoffee() {
		return new Cappuccino();
	}

	@Override
	public Tea createTea() {
		return new ChinaTea();
	}

	@Override
	public Sodas createSodas() {
		return null;
	}

}
