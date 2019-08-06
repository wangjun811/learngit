package com.test.demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListDemo {

	public static void main(String[] args) {
		Map<String, Object> map1 = new HashMap<>();
		map1.put("prty", "6");
		Map<String, Object> map2 = new HashMap<>();
		map2.put("prty", "2");
		Map<String, Object> map3 = new HashMap<>();
		map3.put("prty", "5");
		
		List<Map<String, Object>> list = new ArrayList<>();
		list.add(map1);
		list.add(map2);
		list.add(map3);
		
		Collections.sort(list, new Comparator<Map<String, Object>>() {

			@Override
			public int compare(Map<String, Object> o1, Map<String, Object> o2) {
				return Integer.parseInt((String) o1.get("prty")) - Integer.parseInt((String) o2.get("prty"));
			}
			
		});
		
		for (Map<String, Object> map : list) {
			System.out.println(map.get("prty"));
		}
		
		System.out.println(new ListDemo().hashCode());
		System.out.println(new ListDemo().hashCode());
	}
	
	
	
}
