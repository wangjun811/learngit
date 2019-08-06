package com.test.demo;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class StringValueOfDemo {

	public static void main(String[] args) {
		test1();
	}
	
	public static void test1() {
		Map<String, Object> map = new HashMap<String, Object>();
		String count = String.valueOf(map.get("abc"));
		String str = null;
		if("null".equals(count)){
			BigDecimal decimal = new BigDecimal(str);
			System.out.println(decimal);
		}
		
	}
}
