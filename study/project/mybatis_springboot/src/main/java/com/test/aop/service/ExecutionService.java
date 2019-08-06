package com.test.aop.service;

import org.springframework.stereotype.Service;

@Service
public class ExecutionService {

	public void executeMethod(String param1, int param2) {
		System.out.println("invoke executeMethod:" + param1 + " " + param2);
	}
}
