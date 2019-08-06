package com.test.generic.array;

public class ArrayOfGeneric {

	static final int SIZE = 100;

	static Generic<Integer>[] gia;

	public static void main(String[] args) {
		gia = (Generic<Integer>[]) new Generic[SIZE];
		System.out.println(gia.getClass().getSimpleName());
		gia[1] = new Generic<Integer>();
		System.out.println(gia.length);
	}
}
