package com.test.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.test.dao.UserDao;
import com.test.model.User;
import com.test.service.OperateService;
import com.test.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private OperateService operate;

	@Override
	public User getNameById(User user) {
		return userDao.getNameById(user);
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	@Override
	public void addUser(User user) {
		userDao.addUser(user);
		try{
			operate.operate();
		}catch(Exception e){
			System.out.println("≤∂ªÒ“Ï≥£¡À°£°£°£°£°£°£");
		}
	}

}
