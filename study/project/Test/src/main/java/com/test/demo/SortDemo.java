package com.test.demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class SortDemo {

	private static final Map<String, Integer> TERM_MAP = new HashMap<String, Integer>() {

		private static final long serialVersionUID = 3303110731524053056L;

		{
			put("001", 17);
			put("002", 19);
			put("003", 20);
			put("005", 21);
			put("099", 22);
			put("101", 5);
			put("102", 7);
			put("103", 8);
			put("104", 9);
			put("105", 10);
			put("106", 11);
			put("107", 12);
			put("108", 13);
			put("109", 14);
			put("110", 15);
			put("111", 16);
			put("118", 18);
			put("200", 1);
			put("201", 2);
			put("207", 3);
			put("214", 4);
			put("235", 6);
		}
	};

	public static void main(String[] args) {
		System.out.println(TERM_MAP.size());
		List<Map.Entry<String, Integer>> termEntryList = new ArrayList<>(TERM_MAP.entrySet());
		Collections.sort(termEntryList, new Comparator<Map.Entry<String, Integer>>() {
			@Override
			public int compare(Entry<String, Integer> entry1, Entry<String, Integer> entry2) {
				return entry1.getValue().compareTo(entry2.getValue());
			}
		});
		
		for (Map.Entry<String, Integer> entry : termEntryList) {
			System.out.println(entry.getValue() + ":" + entry.getKey());
		}
	}
}
