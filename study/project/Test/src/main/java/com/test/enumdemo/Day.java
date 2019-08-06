package com.test.enumdemo;

public enum Day {

	MONDAY("����һ"), TUESDAY("���ڶ�"), WEDNESDAY("������"), THURSDAY("������"), FRIDAY("������"), SATURDAY("������"), SUNDAY("������");

	private String desc;

	private Day(String desc) {
		this.desc = desc;
	}

	public String getDesc() {
		return this.desc;
	}
	
	@Override
	public String toString() {
		return this.desc;
	}

	public static void main(String[] args) {
		Day[] days = Day.values();
		for (int i = 0; i < days.length; i++) {
			System.out.println("name:" + days[i].name() + ", desc:" + days[i].toString());
		}
	}
}
