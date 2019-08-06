package com.test.demo;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringDemo {

	public static void main(String[] args) {
//		testSpecialStr();
		
//		Map<String, Object> map = (Map<String, Object>)null;
//		System.out.println("map:" + map);
		
//		String str = "12";
//		Pattern pattern=Pattern.compile("^([1-9]{1,2})$");
//		Matcher match=pattern.matcher(str);
//		System.out.println(validateDecimal("3", 18, 2));
//		
//		String[] strs = new String[]{"a","b","c"};
//		System.out.println(strs);
		
		String str = "abcdef";
		System.out.println(str.charAt(0));
		System.out.println(str.substring(0, 2));
	}

	public static void testSpecialStr() {
		String str = "~#$%^&~#￥%&<>\"{}";
		System.out.println(str.indexOf("\""));
	}

	public static Map<String, Object> validateSpecialCharacter(String content) {

		for (int i = 0; i < content.length(); i++) {
		}

		return null;
	}
	
	public static final String SPECIAL_CHARACTER = null; 
	
	/**
     * 正则校验字符串是否为decimal
     * @param str
     * @return
     */
    public static boolean validateDecimal(String str, int totalDigits, int decimalDigits){
    	Pattern pattern=Pattern.compile("^(([0]{1})|([1-9]\\d{0," + (totalDigits - decimalDigits - 1)  + "}))(\\.(\\d){1," + decimalDigits + "})?$");
    	Matcher match=pattern.matcher(str);
    	return match.matches();
    }
}
