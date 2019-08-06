package com.test.proxy.cglib;

public class PersonService {

	public PersonService() {
		System.out.println("PersonService¹¹Ôì");
	}

	final public Person getPerson(String code) {
		System.out.println("PersonService:getPerson>>" + code);
		return null;
	}
	
	public void setPerson() {
		System.out.println("PersonService:setPerson");
	}
}
