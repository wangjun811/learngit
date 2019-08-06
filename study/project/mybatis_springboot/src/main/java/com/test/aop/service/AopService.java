package com.test.aop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.dao.UserDao;
import com.test.model.Stu;
import com.test.model.User;
import com.test.persistence.StuDao;

@Service
public class AopService {

	@Autowired
	private UserDao userDao;

	public void addUser() {
		userDao.addUser(new User("789", "addUser"));
	}
	
	@Autowired
	private StuDao stuDao;
	
	public void addStu() {
		stuDao.addStu(new Stu("stu1", 18));
	}
}
