package com.test.jvm;

public class JvmConfig {

	public static void main(String[] args) {
		System.out.println("���ѣ�" + Runtime.getRuntime().maxMemory() / 1024 / 1024 + "M");
		System.out.println("���жѣ�" + Runtime.getRuntime().freeMemory() / 1024 / 1024 + "M");
		System.out.println("�ܵĶѣ�" + Runtime.getRuntime().totalMemory() / 1024 / 1024 + "M");
		
		byte[] bytes = null;
		
		for (int i=0;i<100;i++) {
			bytes = new byte[1*1024*1024];
		}
	}
}
