package com.test.demo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeDemo {

	public static void main(String[] args) {
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		System.out.println(format.format(new Date()));
	}
}
