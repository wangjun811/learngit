package com.test.enumdemo;

public enum Day {

	MONDAY("星期一"), TUESDAY("星期二"), WEDNESDAY("星期三"), THURSDAY("星期四"), FRIDAY("星期五"), SATURDAY("星期六"), SUNDAY("星期天");

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
