package com.test.design.decorator;

public class Client {

	public static void main(String[] args) {

		System.out.println("=======��ʼװ����ͷ");
		IBread normalBread = new NormalBread();
		normalBread = new SweetDecorator(normalBread);
		normalBread = new CornDecorator(normalBread);
		normalBread.process();
		System.out.println("=======װ����ͷ����");
	}
}