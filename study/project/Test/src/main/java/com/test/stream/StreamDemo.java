package com.test.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo {

	public static void main(String[] args) {
		StreamDemo demo = new StreamDemo();
		demo.testDoubleColon2();
	}

	public List<String> list = new ArrayList<String>() {

		private static final long serialVersionUID = 7640517353399764712L;

		{
			add("a");
			add("b");
			add("c");
		}

	};

	public void test() {
		list.stream().filter((param) -> param.equals("b")).collect(Collectors.toList())
				.forEach((param) -> System.out.println(param));

		Stream.of("a", "b", "hello").map((param) -> {
			return param.toUpperCase();
		}).collect(Collectors.toList()).forEach((param) -> System.out.println(param));
	}

	/**
	 * stream中map与flatMap的区别
	 * flatMap主要是用于stream合并，这个功能非常实用，他是默认实现多CPU并行执行的，所以我们合并集合优先使用这种方式
	 */
	public void testStreamMapMethod() {
		String[] strs = { "jdk8", "mysql", "tomcat" };
		Arrays.stream(strs).filter((param) -> param.length() > 4).map((param) -> param.split(""))
				.forEach((param -> System.out.println(Arrays.asList(param).toString())));

		Arrays.stream(strs).filter((param) -> param.length() > 4).map((param) -> param.split(""))
				.flatMap((param) -> Arrays.stream(param)).forEach((param) -> System.out.println(param));

		List<String> list = new ArrayList<String>() {
			private static final long serialVersionUID = 5214413698568274357L;

			{
				add("nginx");
				add("jekins");
				add("linux");
			}
		};
		list.stream().map(String::toUpperCase).collect(Collectors.toList()).forEach(System.out::println);
	}

	public void testStreamListFlatMapMethod() {
		List<List<String>> lists = new ArrayList<List<String>>() {
			private static final long serialVersionUID = 2215591618532340372L;

			{
				add(new ArrayList<String>() {

					private static final long serialVersionUID = 8896359739011583537L;

					{
						add("a");
						add("b");
						add("a");
						add("c");
					}
				});

				add(new ArrayList<String>() {

					private static final long serialVersionUID = -6839682911602285421L;

					{
						add("x");
						add("y");
						add("z");
					}
				});
			}
		};

		lists.stream().filter((list) -> list.contains("a")).flatMap((list) -> list.stream()).collect(Collectors.toSet())
				.forEach(System.out::println);

		List<String> strs = new ArrayList<>();
		strs.add("e");
		strs.add("f");
		strs.add("e");
		strs.add("g");
		strs.add("f");

		strs.stream().collect(Collectors.toSet()).forEach(System.out::println);

	}

	/**
	 * 测试双冒号用法
	 */
	public void testDoubleColon() {
		// Stream.of("a", "b",
		// "c").collect(Collectors.toList()).forEach(Example::repair);

		Arrays.asList(new Example()).stream().map(Util::change);

		Example example = new Example();
		Stream.of("x", "y", "z").collect(Collectors.toList()).forEach(example::print);

		Stream.of("x", "y", "z").collect(Collectors.toList()).forEach((param) -> System.out.println());
	}

	/**
	 * 测试stream的reduce方法
	 */
	public void testStreamReduce() {
		List<String> strs = new ArrayList<String>() {

			private static final long serialVersionUID = 1374967859719727176L;

			{
				add("1");
				add("2");
				add("3");
			}
		};

		String str = strs.stream().reduce((a, b) -> a + b).get();
		System.out.println(str);

		List<Integer> ints = new ArrayList<Integer>() {

			private static final long serialVersionUID = -8903854193875893789L;

			{
				add(1);
				add(2);
				add(3);
			}
		};

		int sum = ints.stream().reduce((a, b) -> {
			return a + b;
		}).get();
		System.out.println(sum);

		ints.stream().reduce(new ArrayList<String>(), (a, b) -> {
			a.add("element-" + Integer.valueOf(b));
			return a;
		} , (a, b) -> null).forEach(System.out::println);
		;

	}

	public void testDoubleColon2() {
		Example example1 = new Example();
		Example example2 = new Example();

		List<Example> examples = new ArrayList<>();
		examples.add(example1);
		examples.add(example2);

		Util util = new Util();

		examples.stream().map(util::getStr).collect(Collectors.toList()).forEach(System.out::println);
	}

}

class Example {

	public static void staticPrint(String str) {
		System.out.println("static:" + str);
	}

	public String returnStr() {
		return "a";
	}

	public void print(String str) {
		System.out.println("non static:" + str);
	}

	public void repair() {
		System.out.println("repair");
	}

}

class Util {

	public static String change(Example example) {
		return null;
	}

	public String getStr(Example example) {
		return "str";
	}
}