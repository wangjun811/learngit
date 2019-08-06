package com.test.demo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateDemo {
	
	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		format.setLenient(false);
		Date effDt = null;
		effDt = format.parse("2019029");
		System.out.println(format.format(effDt));
//		System.out.println(validateDecimal("-666", 18, 2));
	}

	/**
     * 正则校验字符串是否为decimal
     * @param str
     * @return
     */
    public static boolean validateDecimal(String str, int totalDigits, int decimalDigits){
    	Pattern pattern=Pattern.compile("^(-)?(([0]{1})|([1-9]\\d{0," + (totalDigits - decimalDigits - 1)  + "}))(\\.(\\d){1," + decimalDigits + "})?$");
    	Matcher match=pattern.matcher(str);
    	return match.matches();
    }
}
