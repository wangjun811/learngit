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
	 * �������飬�ᱨ��
	 * �ڴ����У���������Ĵ����Ǵ���һ��Object���飬Ȼ��ת��ΪT[]���������ʵ�����ͻ���Object[]��
	 * �ڵ���rep()������ʱ�򣬾ͱ�ClassCastException�쳣�ˣ���ΪObject[]�޷�ת��ΪInteger[]��
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		GenericArray<Integer> gai = new GenericArray<Integer>(10);
//		Integer[] ia = gai.rep();
	}
}
