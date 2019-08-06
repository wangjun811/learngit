package com.test.design.decorator;

public class SweetDecorator extends AbstractBread {

	public SweetDecorator(IBread bread) {

		super(bread);
	}

	public void paint() {

		System.out.println("���������...");
	}

	@Override
	public void kneadFlour() {
		// ��������غ����
		this.paint();
		super.kneadFlour();
	}

}