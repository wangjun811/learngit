package com.test.demo;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class DirTest {

	static Map<String, Integer> map = new HashMap<>();

	public static void main(String[] args) {
		File file = new File("D:/Pha_Branch/bosent1611_tcms/tcms_fee/bosent-baseline-hot-deploy");
		listFile(file);

		for (Entry<String, Integer> entry : map.entrySet()) {
			if (entry.getValue() > 1) {
				System.out.println(entry.getKey() + ":" + entry.getValue());
			}
		}
	}

	public static void listFile(File dir) {
		File[] files = dir.listFiles();
		for (File file : files) {
			if (file.isDirectory()) {
				listFile(file);
			} else {
				if (file.getAbsolutePath().endsWith(".java")) {
					String fileName = file.getName();
					if (map.containsKey(fileName)) {
						map.put(fileName, (map.get(fileName) + 1));
					} else {
						map.put(fileName, 1);
					}
				}
			}
		}
	}
}
