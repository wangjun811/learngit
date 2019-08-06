package com.test.demo;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Map.Entry;

public class MapDemo {

	public static void main(String[] args) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> temp = new HashMap<String, Object>();
		temp.put("c", "3");
		map.put("a", "1");
		map.put("b", "2");
		map.putAll(temp);
		
		for(Entry<String, Object> entry : map.entrySet()) {
			System.out.println(entry.getValue());
		}
		
		System.out.println(String.valueOf(temp.get("str") == null));
		
		Hashtable<String, String> table = new Hashtable<String, String>();
	}
}
