package com.test.lambda;

import java.util.ArrayList;
import java.util.Arrays;

public class Demo {

	public static void main(String[] args) {
		Supporter supporter = () -> {
			System.out.println("End");
			System.out.println("...");
		};
		supporter.support();

		ArrayList<String> list = new ArrayList<>();
		list.add("a");
		list.add("b");
		list.add("c");
		list.forEach((str) -> System.out.println(str));

		String[] array = { "abc", "jk", "aghjghj", "u" };
		System.out.println(Arrays.toString(array));
		// 排序,长度由大到小输出
		Arrays.sort(array, (a, b) -> {
			return a.length() - b.length();
		});
		System.out.println(Arrays.toString(array));
		
		new Demo().test(() -> System.out.println("drink tea"));
		
		String fruit = "apple";
		
		Operator1 o1 = (str) -> {str = "12";System.out.println(str);};
		o1.eat(fruit);
		
		fruit = "orange";
		
		o1.eat(fruit);
	}
	
	public void test(Operator1 person) {
		
	}
	
	public void test(Operator2 person) {
		person.drink();
	}
}
