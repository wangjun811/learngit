package com.test.extend;

public abstract class Animal implements EatAction {

	public void beforeEat() {
		System.out.println("before eat......");
	}
	
	public void afterEat() {
		System.out.println("after eat......");
	}
	
	public void eatService() {
		beforeEat();
		
		eat();
		
		afterEat();
	}
}
