package com.test.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;

public class CglibTest {

	public static void main(String[] args) {
		 //������class�ļ����뱾�ش���
//        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "D:\\code");
		
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(PersonService.class);
		enhancer.setCallback(new CglibProxyInterceptor());
		PersonService proxy = (PersonService) enhancer.create();
		proxy.setPerson();
		proxy.getPerson("1");
	}
}
