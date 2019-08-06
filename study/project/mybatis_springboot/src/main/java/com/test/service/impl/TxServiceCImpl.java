package com.test.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.test.dao.UserDao;
import com.test.model.User;
import com.test.service.TxServiceC;

@Service
public class TxServiceCImpl implements TxServiceC {

	@Autowired
	private UserDao userDao;
	
	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public void serviceCcc() {
		System.out.println("ServiceCcc......");
		
		userDao.addUser(new User("idCcc", "serviceCcc"));

		throw new RuntimeException();
	}

}
