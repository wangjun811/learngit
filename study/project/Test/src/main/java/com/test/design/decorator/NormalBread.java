package com.test.design.decorator;

public class NormalBread implements IBread {

	@Override
	public void prepair() {

		System.out.println("׼�����,ˮ�Լ����ͷ�...");
	}

	@Override
	public void kneadFlour() {

		System.out.println("����...");
	}

	@Override
	public void steamed() {

		System.out.println("����ͷ...���������ͷ��¯��");
	}

	@Override
	public void process() {

		prepair();
		kneadFlour();
		steamed();
	}

}