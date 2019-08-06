package com.test.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class IteratorDemo {

	public static void main(String[] args) {
		ArrayList<String> strs = new ArrayList<>();
		strs.add("a");
		strs.add("b");
		strs.add("c");
		
		ListIterator<String> it = strs.listIterator();
		while(it.hasNext()) {
			String temp = it.next();
			if ("b".equals(temp)) {
				System.out.println(it.previous());
				if(it.hasPrevious()) {
					System.out.println(it.previous());
					break;
				} else {
					System.out.println("meiyou");
					break;
				}
			}
			
		}
	}
}
