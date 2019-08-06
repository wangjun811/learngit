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
		 * 这是一个真正的泛型方法。
		 * 首先在public与返回值之间的<T>必不可少，这表明这是一个泛型方法，并且声明了一个泛型T
		 * 泛型的数量也可以为任意多个 
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
	 * 泛型方法和可变参数的例子
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
     * 如果在类中定义使用泛型的静态方法，需要添加额外的泛型声明（将这个方法定义成泛型方法）
     * 即使静态方法要使用泛型类中已经声明过的泛型也不可以。
     * 如：public static void show(T t){..},此时编译器会提示错误信息：
          "StaticGenerator cannot be refrenced from static context"
     */
	public static <T> void show(T t) {
		
	}
	
	/**
	 * 泛型上下边界
	 * 为泛型添加上边界，即传入的类型实参必须是指定类型的子类型
	 * 
	 * @param obj
	 */
	public void showKeyValue1(Generic<? extends Number> obj) {
		System.out.println("泛型测试，key value is " + obj.getKey());
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
