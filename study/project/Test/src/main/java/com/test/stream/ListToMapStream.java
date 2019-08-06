package com.test.stream;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ListToMapStream {

	public static void main(String[] args) {
		List<Apple> appleList = new ArrayList<>();
		Apple apple1 = new Apple(1, "Æ»¹û1", new BigDecimal("3.25"), 10);
		Apple apple12 = new Apple(1, "Æ»¹û2", new BigDecimal("1.35"), 20);
		Apple apple2 = new Apple(2, "Ïã½¶", new BigDecimal("2.89"), 30);
		Apple apple3 = new Apple(3, "ÀóÖ¦", new BigDecimal("9.99"), 40);
		
		appleList.add(apple1);
		appleList.add(apple12);
		appleList.add(apple2);
		appleList.add(apple3);
		
		listToMap(appleList);
	}
	
	public static void testGroup(List<Apple> appleList) {
		Map<Integer, List<Apple>> groupBy = appleList.stream().collect(Collectors.groupingBy(Apple::getId));
		System.out.println(groupBy);
	}
	
	public static void listToMap(List<Apple> appleList) {
		Map<Integer, Apple> appleMap = appleList.stream().collect(Collectors.toMap(Apple::getId, a -> a, (k1, k2) -> k1));
		System.out.println(appleMap);
	}
}

class Apple {
	private Integer id;
	
	private String name;
	
	private BigDecimal money;
	
	private Integer num;
	
	public Apple (Integer id, String name, BigDecimal money, Integer num) {
		this.id = id;
		this.name = name;
		this.money = money;
		this.num = num;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getMoney() {
		return money;
	}

	public void setMoney(BigDecimal money) {
		this.money = money;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}
	
}
