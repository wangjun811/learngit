package com.test.design.decorator;

public class CornDecorator extends AbstractBread {

	public CornDecorator(IBread bread) {

		super(bread);
	}

	public void paint() {

		System.out.println("������ʻƵ���ɫ��");
	}

	@Override
	public void kneadFlour() {
		// �����ɫ�������
		this.paint();
		super.kneadFlour();
	}

}