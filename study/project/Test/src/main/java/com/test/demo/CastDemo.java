package com.test.demo;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


public class CastDemo {

	public static void main(String[] args) {
//		HashMap<String, Object> map = new HashMap<String, Object>();
//		map.put("num", 12.23);
//		System.out.println(map.get("num") instanceof Number);
		test();
		System.out.println("abc".substring(0, 2));
	}
	
	public static void test() {
		Class c = Map.class;
		Map<String, Object> map = new HashMap<>();
		String str = (String) map.get("str");
		System.out.println(str);
	}

	public static boolean isEmpty(Object value) {
		if (value == null)
			return true;

		if (value instanceof String)
			return ((String) value).length() == 0;
		if (value instanceof Collection)
			return ((Collection<? extends Object>) value).size() == 0;
		if (value instanceof Map)
			return ((Map<? extends Object, ? extends Object>) value).size() == 0;
		if (value instanceof CharSequence)
			return ((CharSequence) value).length() == 0;

		// These types would flood the log
		// Number covers: BigDecimal, BigInteger, Byte, Double, Float, Integer,
		// Long, Short
		if (value instanceof Boolean)
			return false;
		if (value instanceof Number)
			return false;
		if (value instanceof Character)
			return false;
		if (value instanceof java.util.Date)
			return false;

		return false;
	}
}
