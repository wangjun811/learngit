package com.test.enumdemo;

import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Map.Entry;

public class Test {

	public static void main(String[] args) {
		// Day[] days = Day.values();
		// System.out.println(Arrays.toString(days));
		// Day day = Day.valueOf("MONDAY");
		// System.out.println(day);

		System.out.println(EnumTest.FRI.getValue());

		EnumSet<EnumTest> weekSet = EnumSet.allOf(EnumTest.class);
		for (EnumTest day : weekSet) {
			System.out.println(day);
		}

		EnumMap<EnumTest, String> weekMap = new EnumMap(EnumTest.class);
		weekMap.put(EnumTest.MON, "����һ");
		weekMap.put(EnumTest.TUE, "���ڶ�");

		for (Iterator<Entry<EnumTest, String>> iter = weekMap.entrySet().iterator(); iter.hasNext();) {
			Entry<EnumTest, String> entry = iter.next();
			System.out.println(entry.getKey().name() + ":" + entry.getValue());
		}
	}
}
