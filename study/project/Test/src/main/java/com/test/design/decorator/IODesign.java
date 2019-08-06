package com.test.design.decorator;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class IODesign {

	public static void main(String[] args) throws FileNotFoundException {
		FileInputStream in = new FileInputStream("");
		BufferedInputStream br = new BufferedInputStream(in);
	}
}
