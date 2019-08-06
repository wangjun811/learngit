package com.test.factoryMode;

/**
 * 
 * 定义一个抽象的咖啡工厂
 * 
 */
public abstract class CoffeeFactory {

	/**
	 * 生产可制造的咖啡
	 * @return
	 */
	public abstract Coffee[] createCoffee();
}
