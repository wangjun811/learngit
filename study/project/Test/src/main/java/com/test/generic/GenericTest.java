package com.test.generic;

import java.util.List;

public class GenericTest {

	public class Generic<T> {
		
		private T key;
		
		public Generic(T key) {
			this.key = key;
		}
		
		public T getKey() {
			return key;
		}
		
		public void showKey(T obj) {
			System.out.println(obj);
		}
		
		/**
		 * ����һ�������ķ��ͷ�����
		 * ������public�뷵��ֵ֮���<T>�ز����٣����������һ�����ͷ���������������һ������T
		 * ���͵�����Ҳ����Ϊ������ 
		 * 
		 * @param list
		 */
		@SuppressWarnings("hiding")
		public <T> void showValue(List<T> list) {
			for(T str : list){
				System.out.println(str);
			}
		}
	}
	
	/**
	 * ���ͷ����Ϳɱ����������
	 * 
	 * @param args
	 */
	@SuppressWarnings("unchecked")
	public <T> void pringMsg(T... args) {
		System.out.println("pringMsg start...");
		for(T t : args){
			System.out.println(t);
		}
	}
	
	/**
     * ��������ж���ʹ�÷��͵ľ�̬��������Ҫ��Ӷ���ķ����������������������ɷ��ͷ�����
     * ��ʹ��̬����Ҫʹ�÷��������Ѿ��������ķ���Ҳ�����ԡ�
     * �磺public static void show(T t){..},��ʱ����������ʾ������Ϣ��
          "StaticGenerator cannot be refrenced from static context"
     */
	public static <T> void show(T t) {
		
	}
	
	/**
	 * �������±߽�
	 * Ϊ��������ϱ߽磬�����������ʵ�α�����ָ�����͵�������
	 * 
	 * @param obj
	 */
	public void showKeyValue1(Generic<? extends Number> obj) {
		System.out.println("���Ͳ��ԣ�key value is " + obj.getKey());
	}
	
	public <T extends Number> T showKeyName(Generic<T> container) {
		System.out.println("container key :" + container.getKey());
		T key = container.getKey();
		return key;
	}
	
	public static void main(String[] args) {
		GenericTest test = new GenericTest();
		test.showKeyName(test.new Generic<Integer>(12));
	}
}
