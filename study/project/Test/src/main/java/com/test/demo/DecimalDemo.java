package com.test.demo;

import java.math.BigDecimal;

public class DecimalDemo {

	public static void main(String[] args) {
		new BigDecimal((String)(null));
		stripTrailingZeros();
	}
	
	public static void stripTrailingZeros() {
		System.out.println(new BigDecimal("10.00").stripTrailingZeros().toPlainString());
		System.out.println(new BigDecimal("-20.2600").abs().stripTrailingZeros().toPlainString());
	}
}
