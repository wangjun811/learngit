package com.test.generic.array;

public class GenericArray<T> {

	private T[] array;
	
	@SuppressWarnings("unchecked")
	public GenericArray(int size) {
		array = (T[]) new Object[size];
	}
	
	public void put(int index, T item) {
		array[index] = item;
	}
	
	public T get(int index) {
		return array[index];
	}
	
	public T[] rep() {
		return array;
	}
	
	/**
	 * 返回数组，会报错
	 * 在代码中，泛型数组的创建是创建一个Object数组，然后转型为T[]。但数组的实际类型还是Object[]。
	 * 在调用rep()方法的时候，就报ClassCastException异常了，因为Object[]无法转型为Integer[]。
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		GenericArray<Integer> gai = new GenericArray<Integer>(10);
//		Integer[] ia = gai.rep();
	}
}
