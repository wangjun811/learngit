package com.test.enumdemo;

public class EnumSwitch {

	public static void printName(Color color) {
		switch (color) {
		case RED:
			System.out.println("ºìÉ«");
			break;
		case YELLOW:
			System.out.println("»ÆÉ«");
			break;
		case BLUE:
			System.out.println("À¶É«");
			break;
		}
	}
	
	public static void main(String[] args) {
		EnumSwitch.printName(Color.BLUE);
	}
}
