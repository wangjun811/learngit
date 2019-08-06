package com.test.demo;

public class Outer {
	public static class Inner {
		Outer owner;
		static String constant;

		static {
			constant = "foo";
		}

		private Inner(Outer owner) {
			if (owner == null) {
				throw new NullPointerException();
			}
			this.owner = owner;
		}
	}

	public Inner newInner() {
		return new Inner(this);
	}
}