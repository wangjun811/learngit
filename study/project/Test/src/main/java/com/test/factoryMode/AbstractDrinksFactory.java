package com.test.factoryMode;

public interface AbstractDrinksFactory {

	public abstract Coffee createCoffee();

	public abstract Tea createTea();

	public abstract Sodas createSodas();
}
