package com.test.enumdemo;

public class EnumSwitch {

	public static void printName(Color color) {
		switch (color) {
		case RED:
			System.out.println("��ɫ");
			break;
		case YELLOW:
			System.out.println("��ɫ");
			break;
		case BLUE:
			System.out.println("��ɫ");
			break;
		}
	}
	
	public static void main(String[] args) {
		EnumSwitch.printName(Color.BLUE);
	}
}
