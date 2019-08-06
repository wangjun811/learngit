package com.test.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.test.service.OperateService;

@Service
public class OperateServiceImpl implements OperateService {

	@Transactional(propagation=Propagation.REQUIRED)
	@Override
	public void operate() {
		System.out.println("operate......");
		throw new RuntimeException();
	}

}
