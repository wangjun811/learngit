package com.test.service.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.test.dao.UserDao;
import com.test.model.User;
import com.test.service.TxServiceB;
import com.test.service.TxServiceC;

@Service
public class TxServiceBImpl implements TxServiceB {

	@Autowired
	private UserDao userDao;
	
	@Resource
	private TxServiceC txServiceC;
	
	@Transactional(propagation=Propagation.REQUIRED)
	@Override
	public void serviceB() {
		userDao.addUser(new User("777", "serviceB"));
		
		throw new RuntimeException();
	}
	
	@Transactional
	public String serviceBb() {
		try {
			System.out.println("调用ServiceBb......");
			
			userDao.addUser(new User("idBb", "serviceBb"));
			
			txServiceC.serviceCcc();
		} catch(Exception e) {
			 System.out.println("调用ServiceCcc异常了......");
			 
			 return "invoke failed";
		}
		
		return "invoke Successful";
	}

}
