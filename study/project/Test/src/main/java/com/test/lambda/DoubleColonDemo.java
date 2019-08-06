package com.test.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;


public class DoubleColonDemo {

	public static class Car {
		public static Car create( final Supplier< Car > supplier ) {
	        return supplier.get();
	    }              

	    public static void collide( final Car car ) {
	        System.out.println( "Collided " + car.toString() );
	    }

	    public void follow( final Car another ) {
	        System.out.println( "Following the " + another.toString() );
	    }

	    public void repair() {   
	        System.out.println( "Repaired " + this.toString() );
	    }
	}
	
	public static void main(String[] args) {
		DoubleColonDemo demo = new DoubleColonDemo();
		demo.test1();
	}
	
	public void test1() {
		Car car = Car.create(Car::new);
	}
	
	public void test2() {
		Car car = Car.create(Car::new);
		List<Car> cars = Arrays.asList(car);
	}
	
	public void test3() {
		Car car = Car.create(Car::new);
		List<Car> cars = Arrays.asList(car);
		
		cars.forEach(Car::repair);
	}
	
	public void test4() {
		
	}
	
}
