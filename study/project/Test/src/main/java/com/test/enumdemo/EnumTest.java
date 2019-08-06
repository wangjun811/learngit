package com.test.enumdemo;

public enum EnumTest {

	MON(1), TUE(2), WED(3), THU(4), FRI(5), SAT(6) {
		public boolean isRest() {
			return true;
		}
	},
	SUN(0) {
		public boolean isRest() {
			return true;
		}
	};

	private int value;

	private EnumTest(int value) {
		this.value = value;
	}

	public int getValue() {
		return this.value;
	}

	public boolean isRest() {
		return false;
	}
}
