package com.test.demo;

import java.util.regex.Pattern;

public class NumberDemo {

	public static void main(String[] args) {
		String str = "923456789";
		Integer.parseInt(str);
		System.out.println(isInteger(str));
	}
	
	public static void test1() {
		
	}
	
	public static boolean isInteger(String str){
    	Pattern pattern = Pattern.compile("^[1-9]\\d{0,8}$");
    	return pattern.matcher(str).matches();
    }
}
