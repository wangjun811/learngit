package com.springquartz;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {

	public static void main(String[] args) {
		Date date = new Date(1565076900000L);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		String str = format.format(date);
		
		System.out.println(str);
	}
}
